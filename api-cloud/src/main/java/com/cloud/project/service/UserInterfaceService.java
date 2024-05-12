package com.cloud.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.common.model.entity.UserInterfaceInfo;

public interface UserInterfaceService extends IService<UserInterfaceInfo> {
    /**
     * 校验接口信息
     */
    void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b);
    /**
     * 调用次数加一
     */
    boolean invokeCount(long interfaceId, long userId);
}
