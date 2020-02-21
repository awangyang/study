package com.example.springstudy;

import lombok.Data;

/**
 * @author wangyang
 * @date 2020/02/19
 */
@Data
public class Teacher implements Cloneable {
    private String sex;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
