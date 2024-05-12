package com.cloud.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.model.entity.UserInterfaceInfo;
import com.cloud.project.common.ErrorCode;
import com.cloud.project.exception.BusinessException;
import com.cloud.project.mapper.UserInterfaceMapper;
import com.cloud.project.model.enums.InterfaceEnums;
import com.cloud.project.model.enums.RedisEnums;
import com.cloud.project.service.UserInterfaceService;
import com.cloud.project.utils.RedisLock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class UserInterfaceServiceImpl extends ServiceImpl<UserInterfaceMapper, UserInterfaceInfo>
    implements UserInterfaceService{
    @Resource
    private RedisLock redisLock;
    @Override
    public void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = userInterfaceInfo.getId();
        // 创建时，所有参数必须非空
        if (add) {
            if (id<=0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (!Objects.equals(userInterfaceInfo.getStatus(), InterfaceEnums.INTERFACE_STATUS_NORMAL)) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "异常操作");
        }
    }

    /**
     * 调用次数+1 剩余次数-1
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean invokeCount(long interfaceId, long userId) {
        if (interfaceId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String lockKey = RedisEnums.invokeCountLock +RedisEnums.USERID + userId + RedisEnums.INTERFACE + interfaceId;
        // 尝试获取锁
        if (!redisLock.tryLock(lockKey, 10)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "操作过于频繁，请稍后再试");
            }
        }
        try {
            boolean update = this.update().setSql("leftNum = leftNum - 1,totalNum = totalNum + 1")
                    .eq("interfaceInfoId", interfaceId)
                    .eq("userId", userId)
                    .gt("leftNum", 0)
                    .update();
            if (!update) {
                throw new BusinessException(ErrorCode.INVOKE_LEFT_ERROR, "调用次数不足");
            }
            return true;
        }
        finally {
            redisLock.unlock(lockKey);
        }
    }
}




