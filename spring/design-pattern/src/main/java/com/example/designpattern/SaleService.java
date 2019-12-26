package com.example.designpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author wangyang
 * @date 2019/09/10
 */
@Service
public class SaleService {

    @Autowired
    ApplicationContext applicationContext;

    public void sale() {
        System.out.println("----------SaleService-----------");

        SaleEvent saleEvent = new SaleEvent("------------");
        applicationContext.publishEvent(saleEvent);
    }

}
