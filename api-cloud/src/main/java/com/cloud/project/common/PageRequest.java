package com.cloud.project.common;

import com.cloud.project.contant.CommonConstant;
import lombok.Data;

@Data
public class PageRequest {
    /**
     * 当前页
     */
    private long current = 1;
    /**
     * 每页显示条数
     */
    private long pageSize = 10;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序方式
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}
