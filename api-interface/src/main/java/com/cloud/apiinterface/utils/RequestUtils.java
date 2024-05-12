package com.cloud.apiinterface.utils;//package com.cloud.apiinterface.utils;
//
//import cn.hutool.http.HttpRequest;
//import com.cloud.sdk.exception.ApiException;
//import com.cloud.sdk.exception.ErrorCode;
//import lombok.extern.slf4j.Slf4j;
//
//import java.lang.reflect.Field;
//
//@Slf4j
//public class RequestUtils {
//    public static <T> String buildUrl(String baseUrl, T params) throws ApiException {
//        StringBuilder url = new StringBuilder(baseUrl);
//        Field[] fields = params.getClass().getDeclaredFields();
//        boolean isFirstParam = true;
//        for (Field field : fields) {
//            field.setAccessible(true);
//            String name = field.getName();
//            // 跳过serialVersionUID属性
//            if ("serialVersionUID".equals(name)) {
//                continue;
//            }
//            try {
//                Object value = field.get(params);
//                if (value != null) {
//                    if (isFirstParam) {
//                        url.append("?").append(name).append("=").append(value);
//                        isFirstParam = false;
//                    } else {
//                        url.append("&").append(name).append("=").append(value);
//                    }
//                }
//            } catch (IllegalAccessException e) {
//                throw new ApiException(ErrorCode.OPERATION_ERROR, "构建url异常");
//            }
//        }
//        return url.toString();
//    }
//
//    public static <T> String get(String baseUrl, T params) throws ApiException {
//        return get(buildUrl(baseUrl, params));
//    }
//
//    public static String get(String url) {
//        String body = HttpRequest.get(url).execute().body();
//        log.info("【interface】：请求地址：{}，响应数据：{}", url, body);
//        return body;
//    }
//}
