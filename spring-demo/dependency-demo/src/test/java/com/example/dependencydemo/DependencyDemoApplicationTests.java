package com.example.dependencydemo;

import com.example.dependencydemo.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DependencyDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    private UserService userService;

    @Test
    public void test() {
        userService.user();
    }
}
