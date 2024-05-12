package com.cloud.project.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserInterFaceInfoAddRequest implements Serializable {
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 接口Id
     */
    private Long interFaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;
    private static final long serialVersionUID = 1L;
}