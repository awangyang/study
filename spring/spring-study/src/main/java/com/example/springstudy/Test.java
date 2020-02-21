package com.example.springstudy;

/**
 * @author wangyang
 * @date 2020/02/19
 */
public class Test {


    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        Teacher teacher = new Teacher();
        user.setAge(18);
        user.setName("Tony");
        teacher.setSex("男");
        user.setTeacher(teacher);
        User user1 = (User) user.clone();

        System.out.println(user);

        teacher.setSex("1");
        System.out.println(user);
        System.out.println(user1);
    }
}
