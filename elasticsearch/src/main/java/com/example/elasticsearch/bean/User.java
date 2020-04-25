package com.example.elasticsearch.bean;

import lombok.Data;

/**
 * @author Wang Yang
 * @date 2020/4/25 20:46
 */

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String fave;
    private Integer score;
    private String grade;
}
