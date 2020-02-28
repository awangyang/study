package com.example.designpattern;

import org.springframework.context.ApplicationEvent;

/**
 * @author wangyang
 * @date 2019/09/10
 */
public class SaleEvent extends ApplicationEvent {
    public SaleEvent(Object source) {
        super(source);
    }
}
