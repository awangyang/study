package com.example.spring.study.annotation;

import com.example.spring.study.User;
import com.example.spring.study.annotation.config.TestConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Wang Yang
 * @date 2020/4/16 19:24
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

        User bean = context.getBean(User.class);
        System.out.println(bean);

    }
}
