package com.cloud.project.model.dto.interFaceinfo;

import lombok.experimental.Accessors;

@Accessors(chain = true)
public class CurrentRequest {
    private String requestUrl;
    private String requestMethod;
}
