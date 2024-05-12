package com.winkovo.apicloud;

import com.cloud.project.CloudApiApplication;
import com.cloud.project.service.UserInterfaceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudApiApplication.class)
class ApiCloudApplicationTests {
    @Resource
    private UserInterfaceService userInterfaceService;
    @Test
    void contextLoads() {
        boolean b = userInterfaceService.invokeCount(1L, 1L);
        Assertions.assertTrue(b);
    }

}
