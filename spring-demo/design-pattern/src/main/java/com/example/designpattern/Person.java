package com.example.designpattern;

import lombok.Data;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

/**
 * @author wangyang
 * @date 2020/02/18
 */
@Data
public class Person {
    private String id;
    private String username;
    private String email;


    public static void main(String[] args) throws Exception {
        Person user = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("username", user.getClass());
        Method setMethod = pd.getWriteMethod();  // 还有与Wirte方法对应的Read方法
        setMethod.invoke(user, "ccc");
        System.out.println(user);
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {

        }
    }
}
