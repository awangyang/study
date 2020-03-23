package com.example.dependencydemo.controller;

import com.example.dependencydemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Yang
 * @date 2020/3/1 21:59
 */
@RestController
@RequestMapping("/index")
public class UserController {

    @RequestMapping("/getIndex")
    public String getIndex(){
         UserService.userService.user();
         return "index";
    }
}
