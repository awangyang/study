package com.example.design.patterns.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author wangyang
 * @date 2020/04/01
 */
public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        ClassLoader classLoader = Car.class.getClassLoader();
        Class[] clazz = {Runnablee.class};
        MyInvocationHandler invocationHandler = new MyInvocationHandler(car);
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Runnablee o = (Runnablee) Proxy.newProxyInstance(classLoader, clazz, invocationHandler);
        o.run();
    }
}
