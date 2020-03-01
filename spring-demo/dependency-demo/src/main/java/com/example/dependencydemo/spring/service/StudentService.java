package com.example.dependencydemo.spring.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentService {

    @Resource
    private UserService userService;

    public void student() {
        System.out.println("studentService");
        userService.test();
    }

}
