package com.cloud.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.common.model.entity.InterfaceInfo;

public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
