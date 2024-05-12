package com.cloud.project.service.impl.inner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.common.model.entity.InterfaceInfo;
import com.cloud.common.service.InnerInterfaceInfoService;
import com.cloud.project.common.ErrorCode;
import com.cloud.project.exception.BusinessException;
import com.cloud.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 根据url和method获取接口信息
     * @param url url
     * @param method method
     */
    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
