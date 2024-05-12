package com.cloud.client.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.cloud.common.utils.SignUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * Api调用客户端
 * Author:云淡风轻
 */
public class ApiClient {
    String accessKey;
    String secretKey;
    private static final String GATEWAY_URL = "http://localhost:9100/api";
    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getPicture(){
        //创建请求头
        Map<String,String> header = createHeader("");
        //调用网关接口
        return HttpUtil.createGet(GATEWAY_URL + "/picture")
                .addHeaders(header)
                .execute()
                .body();
    }
    /**
     * 创建请求头
     * accessKey: accessKey
     * secretKey: secretKey
     * body: body
     * nonce: 随机数
     * timestamp: 时间戳
     * sign: 签名
     *
     */
    private Map<String,String> createHeader(String body){
        Map<String,String> header = new HashMap<String,String>();
        header.put("accessKey",accessKey);
        // 为了保证安全性，这里不直接传递secretKey，而是通过签名的方式进行验证
        header.put("body",body);
        header.put("nonce", RandomUtil.randomNumbers(10));
        header.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        header.put("sign", SignUtils.generateSign(body,secretKey));
        return header;
    }
}
