package com.cloud.project.model.dto.userInterfaceInfo;

import com.cloud.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterFaceInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * Id
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 接口Id
     */
    private Long interFaceInfoId;

    /**
     * 状态
     */
    private int status;

    private static final long serialVersionUID = 1L;
}