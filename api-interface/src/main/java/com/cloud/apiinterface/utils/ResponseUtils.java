package com.cloud.apiinterface.utils;//package com.cloud.apiinterface.utils;
//
//import com.cloud.apiinterface.exception.BusinessException;
//import com.cloud.sdk.domain.dto.response.ResultResponse;
//import com.cloud.sdk.exception.ApiException;
//import com.cloud.sdk.exception.ErrorCode;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import static com.cloud.apiinterface.utils.RequestUtils.get;
//import java.util.Map;
//
//public class ResponseUtils {
//    public static Map<String, Object> responseToMap(String response) {
//        return new Gson().fromJson(response, new TypeToken<Map<String, Object>>() {
//        }.getType());
//    }
//
//    public static <T> ResultResponse baseResponse(String baseUrl, T params) {
//        String response = null;
//        try {
//            response = get(baseUrl, params);
//            Map<String, Object> fromResponse = responseToMap(response);
//            boolean success = (boolean) fromResponse.get("success");
//            ResultResponse baseResponse = new ResultResponse();
//            if (!success) {
//                baseResponse.setData(fromResponse);
//                return baseResponse;
//            }
//            fromResponse.remove("success");
//            baseResponse.setData(fromResponse);
//            return baseResponse;
//        } catch (ApiException e) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "构建url异常");
//        }
//    }
//}
