package com.example.dependencydemo.service;


public class StudentService {

    public static StudentService studentService = new StudentService();

    private final UserService userService = UserService.userService;

    public void student() {
        System.out.println("studentService");
        userService.test();
    }

}
