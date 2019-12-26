package com.example.designpattern.service;

import org.springframework.stereotype.Service;

/**
 * @author wangyang
 * @date 2019/09/10
 */
@Service
public class SvipUserService implements CardService {
    @Override
    public String getUserType() {
        return "svip";
    }

    @Override
    public double sale(Double price) {
        return price * 0.3;
    }
}
