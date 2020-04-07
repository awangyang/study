package com.example.design.patterns.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangyang
 * @date 2020/04/01
 */
public class MyInvocationHandler implements InvocationHandler {
    Car car;

    public MyInvocationHandler(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("先加油！！！");
        Object invoke = method.invoke(car, args);
        System.out.println("没油了！！！");
        return invoke;
    }
}
