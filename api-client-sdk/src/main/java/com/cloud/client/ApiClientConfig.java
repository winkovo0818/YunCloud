package com.cloud.client;
import com.cloud.client.client.ApiClient;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ComponentScan
public class ApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public ApiClient apiClient(){
        return new ApiClient(accessKey, secretKey);
    }
}
