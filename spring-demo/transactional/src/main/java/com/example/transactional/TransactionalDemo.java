package com.example.transactional;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyang
 * @date 2020/03/24
 */
public class TransactionalDemo {

    @Transactional(rollbackFor = Exception.class)
    public void add() {
        System.out.println("Transactional");
    }
}
