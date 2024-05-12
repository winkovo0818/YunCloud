package com.cloud.apiinterface.controller;

import cn.hutool.http.HttpRequest;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/service")
public class ServiceController {

    /**
     * 必应每日一图
     */
    @GetMapping("/picture")
    public String getPicture() {
        String requestUrl = "https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
        try{
            String responseBody = HttpRequest.get(requestUrl)
                    .execute().body();
            // 解析json 取出第一个图片的url
            String img = JsonParser.parseString(responseBody).getAsJsonObject().get("images").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString();
            return "https://cn.bing.com" + img;
        } catch (Exception e) {
            log.error("请求异常", e);
            return "请求异常";
        }
    }

//    /**
//     * 获取IP信息
//     */
//    @GetMapping("/ipInfo")
//    public ResultResponse getIp(IpInfoParams ipInfoParams) {
//        return baseResponse("https://api.vvhan.com/api/getIpInfo", ipInfoParams);
//    }
}
