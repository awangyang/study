package com.example.design.patterns.proxy.jdk;

/**
 * @author wangyang
 * @date 2020/04/01
 */
public class Car implements Runnablee {

    @Override
    public void run() {
        System.out.println("Car running ............");
    }
}
