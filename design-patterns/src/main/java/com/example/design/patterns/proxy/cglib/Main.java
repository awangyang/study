package com.example.design.patterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author wangyang
 * @date 2020/04/01
 */
public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor(car);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(myMethodInterceptor);
        Car o = (Car) enhancer.create();
        o.run();

    }
}
