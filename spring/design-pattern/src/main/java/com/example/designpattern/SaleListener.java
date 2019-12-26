package com.example.designpattern;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wangyang
 * @date 2019/09/10
 */
@Component
public class SaleListener implements ApplicationListener<SaleEvent> {
    @Override
    public void onApplicationEvent(SaleEvent saleEvent) {
        System.out.println("------------------sale------------------");
    }
}
