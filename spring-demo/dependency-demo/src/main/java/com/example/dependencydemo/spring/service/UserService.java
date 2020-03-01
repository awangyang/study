package com.example.dependencydemo.spring.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {
    @Resource
    private StudentService studentService;

    public void user() {
        System.out.println("userService");
        studentService.student();
    }

    public void test() {
        System.out.println("testService");
    }
}
