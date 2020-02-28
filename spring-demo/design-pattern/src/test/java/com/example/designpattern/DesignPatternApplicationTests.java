package com.example.designpattern;

import com.example.designpattern.service.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignPatternApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SaleService saleService;
    @Autowired
    CardServiceImpl cardServiceImpl;


    @Test
    public void test() {
        saleService.sale();
    }

    @Test
    public void test2() {
        System.out.println(cardServiceImpl.ss("vip", 10.0));
        System.out.println(cardServiceImpl.ss("svip", 10.0));
    }
}
