package com.cloud.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.common.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends IService<User> {
    long userRegister(String userAccount, String userPassword, String checkPassword);
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);
    boolean userLogout(HttpServletRequest request);
    User getLoginUser(HttpServletRequest request);
    Boolean isAdmin(HttpServletRequest request);
}
