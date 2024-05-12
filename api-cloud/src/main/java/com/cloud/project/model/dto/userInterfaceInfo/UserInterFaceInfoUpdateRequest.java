package com.cloud.project.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInterFaceInfoUpdateRequest implements Serializable {
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
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;
    /**
     * 状态
     */
    private int status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}