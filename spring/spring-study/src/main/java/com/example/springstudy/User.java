package com.example.springstudy;

import lombok.Data;

/**
 * @author wangyang
 * @date 2020/02/19
 */
@Data
public class User implements Cloneable {
    private String name;
    private Integer age;
    private Teacher teacher;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.teacher = (Teacher) teacher.clone();
        return user;
    }
}
