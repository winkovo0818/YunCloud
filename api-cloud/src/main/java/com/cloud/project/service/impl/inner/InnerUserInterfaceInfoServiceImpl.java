package com.cloud.project.service.impl.inner;
import com.cloud.common.service.InnerUserInterfaceInfoService;
import com.cloud.project.service.impl.UserInterfaceServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceServiceImpl userInterfaceService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceService.invokeCount(interfaceInfoId, userId);
    }
}
