package com.example.springstudy.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangyang
 * @date 2020/04/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String address;
}
