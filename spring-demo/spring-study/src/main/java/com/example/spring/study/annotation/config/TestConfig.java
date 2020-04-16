package com.example.spring.study.annotation.config;

import com.example.spring.study.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wang Yang
 * @date 2020/4/16 19:25
 */
@Configuration
public class TestConfig {

    @Bean
    public User user(){
        User user = new User();
        user.setEmail("1121");
        user.setUsername("1213");
        user.setId("111");
        return user;
    }

}
