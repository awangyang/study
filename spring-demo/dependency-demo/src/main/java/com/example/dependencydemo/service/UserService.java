package com.example.dependencydemo.service;

public class UserService {

    public static UserService userService = new UserService();


    private final StudentService studentService = StudentService.studentService;

    public void user() {
        System.out.println("userService");
        studentService.student();
    }

    public void test() {
        System.out.println("testService");
    }
}
