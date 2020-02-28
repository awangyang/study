package com.example.springstudy;



import com.example.springstudy.factorybean.Car;
import com.example.springstudy.factorybean.CarFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangyang
 * @date 2019/08/19
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("test.xml");
        User user = (User) bf.getBean("123");
        Car car = (Car) bf.getBean("car");
        CarFactoryBean carFactoryBean = (CarFactoryBean) bf.getBean("&car");

        System.out.println(user.toString());
        System.out.println(car);
        System.out.println(carFactoryBean);
    }
}
