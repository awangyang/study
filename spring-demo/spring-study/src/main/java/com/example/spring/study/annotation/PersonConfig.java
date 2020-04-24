package com.example.springstudy.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyang
 * @date 2020/04/14
 */
@Configuration
public class PersonConfig {
    @Bean
    public Person person(){
        return new Person("zhangsan","beijing");
    }
}
