package com.cloud.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.common.model.entity.UserInterfaceInfo;
import com.cloud.project.annotation.AuthCheck;
import com.cloud.project.common.BaseResponse;
import com.cloud.project.common.DeleteRequest;
import com.cloud.project.common.ErrorCode;
import com.cloud.project.common.ResultUtils;
import com.cloud.project.contant.CommonConstant;
import com.cloud.project.exception.BusinessException;
import com.cloud.project.model.dto.userInterfaceInfo.UserInterFaceInfoAddRequest;
import com.cloud.project.model.dto.userInterfaceInfo.UserInterFaceInfoQueryRequest;
import com.cloud.project.model.dto.userInterfaceInfo.UserInterFaceInfoUpdateRequest;
import com.cloud.project.model.enums.UserEnums;
import com.cloud.project.service.UserInterfaceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/userInterfaceInfo")
@Slf4j
public class UserInterfaceInfoController {
    @Resource
    private UserInterfaceService userInterfaceService;

    @ApiOperation(value = "添加用户接口关系")
    @PostMapping("/add")
    @AuthCheck(mustRole = UserEnums.ADMIN_ROLE)
    public BaseResponse<Long> addUserInterfaceInfo(@RequestBody UserInterFaceInfoAddRequest userInterFaceInfoAddRequest) {
        if (userInterFaceInfoAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterFaceInfoAddRequest, userInterfaceInfo);
        // 校验参数
        userInterfaceService.validInterfaceInfo(userInterfaceInfo, true);
        boolean result = userInterfaceService.save(userInterfaceInfo);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        long newInterfaceInfoId = userInterfaceInfo.getId();
        return ResultUtils.success(newInterfaceInfoId);
    }

    /**
     * 删除信息
     */
    @ApiOperation(value = "删除信息")
    @PostMapping("/delete")
    @AuthCheck(mustRole = UserEnums.ADMIN_ROLE)
    public BaseResponse<Boolean> deleteUserInterfaceInfo(@RequestBody DeleteRequest deleteRequest) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = deleteRequest.getId();
        // 判断是否存在
        UserInterfaceInfo oldUserInterfaceInfo = userInterfaceService.getById(id);
        if (oldUserInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        boolean b = userInterfaceService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新信息
     */
    @ApiOperation(value = "更新信息")
    @PostMapping("/update")
    @AuthCheck(mustRole = UserEnums.ADMIN_ROLE)
    public BaseResponse<Boolean> updateUserInterfaceInfo(@RequestBody UserInterFaceInfoUpdateRequest userInterFaceInfoUpdateRequest) {
        if (userInterFaceInfoUpdateRequest == null || userInterFaceInfoUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterFaceInfoUpdateRequest, userInterfaceInfo);
        // 参数校验
        userInterfaceService.validInterfaceInfo(userInterfaceInfo, false);
        long id = userInterFaceInfoUpdateRequest.getId();
        // 判断是否存在
        UserInterfaceInfo oldUserInterfaceInfo = userInterfaceService.getById(id);
        if (oldUserInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        boolean result = userInterfaceService.updateById(userInterfaceInfo);
        return ResultUtils.success(result);
    }
    /**
     * 获取接口信息
     */
    @ApiOperation(value = "获取信息")
    @GetMapping("/get")
    @AuthCheck(mustRole = UserEnums.ADMIN_ROLE)
    public BaseResponse<UserInterfaceInfo> getUserInterfaceInfoById(long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = userInterfaceService.getById(id);
        return ResultUtils.success(userInterfaceInfo);
    }
    /**
     * 获取接口信息列表
     */
    @ApiOperation(value = "获取信息列表")
    @AuthCheck(mustRole = UserEnums.ADMIN_ROLE)
    @GetMapping("/list")
    public BaseResponse<List<UserInterfaceInfo>> listUserInterfaceInfo(UserInterFaceInfoQueryRequest userInterFaceInfoQueryRequest) {
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        if (userInterFaceInfoQueryRequest != null) {
            BeanUtils.copyProperties(userInterFaceInfoQueryRequest, userInterfaceInfo);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>(userInterfaceInfo);
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceService.list(queryWrapper);
        return ResultUtils.success(userInterfaceInfoList);
    }
    /**
     * 分页获取信息列表
     */
    @ApiOperation(value = "分页获取接口信息列表")
    @GetMapping("/list/page")
    @AuthCheck(mustRole = UserEnums.ADMIN_ROLE)
    public BaseResponse<Page<UserInterfaceInfo>> listUserInterfaceInfoByPage(UserInterFaceInfoQueryRequest userInterFaceInfoQueryRequest, HttpServletRequest request) {
        if (userInterFaceInfoQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo interfaceInfoQuery = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterFaceInfoQueryRequest, interfaceInfoQuery);
        long current = userInterFaceInfoQueryRequest.getCurrent();
        long size = userInterFaceInfoQueryRequest.getPageSize();
        String sortField = userInterFaceInfoQueryRequest.getSortField();
        String sortOrder = userInterFaceInfoQueryRequest.getSortOrder();
        // 限制爬虫
        if (size > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfoQuery);
        queryWrapper.orderBy(StringUtils.isNotBlank(sortField),
                sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        Page<UserInterfaceInfo> interfaceInfoPage = userInterfaceService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(interfaceInfoPage);
    }
}
