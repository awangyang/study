package com.example.design.patterns.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangyang
 * @date 2020/04/01
 */
public class MyMethodInterceptor implements MethodInterceptor {
    Car car;

    public MyMethodInterceptor(Car car) {
        this.car = car;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("先加油！！！");
        Object invoke = method.invoke(car, objects);
        System.out.println("没油了！！！");
        return invoke;
    }
}
