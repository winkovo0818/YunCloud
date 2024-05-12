package com.cloud.project;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.cloud.project.mapper")
@EnableDubbo
public class CloudApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudApiApplication.class, args);
    }

}