package com.example.designpattern.strategy;

/**
 * @author wangyang
 * @date 2020/03/12
 */
public class ProductFileService extends AbstractFileService {

    @Override
    public String saveAttach(String attach) {

        return "productAttach";
    }
}
