package com.cloud.common.service;
import com.cloud.common.model.entity.User;

public interface InnerUserService {

    User getInvokeUser(String accessKey);
}
