package com.cloud.common.common;

public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NULL_ERROR(40001, "请求数据为空"),
    NOT_LOGIN(40100, "未登录"),
    NO_AUTH(40101, "无权限"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败"),
    NOT_FOUND_ERROR(40400, "请求数据不存在"),
    INVOKE_INTERFACE_ERROR(50002, "接口调用失败"),
    INVOKE_LEFT_ERROR(50003, "接口调用次数不足"),
    INTERFACE_NOT_FOUND(50003, "接口不存在");

    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
