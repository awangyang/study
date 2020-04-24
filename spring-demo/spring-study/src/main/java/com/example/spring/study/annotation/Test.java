package com.example.springstudy.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangyang
 * @date 2020/04/14
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);

        Person person = (Person) context.getBean("person");
//        person.setAddress("beijing");
//        person.setName("Tony");
        System.out.println(person);
    }
}
