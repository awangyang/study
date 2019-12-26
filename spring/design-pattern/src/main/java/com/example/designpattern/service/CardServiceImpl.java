package com.example.designpattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangyang
 * @date 2019/09/10
 */
@Service
public class CardServiceImpl {

    private static Map<String, CardService> map = new ConcurrentHashMap<>(16);

    @Autowired
    public void setCardServices(List<CardService> cardServices) {
        if (cardServices != null) {
            for (CardService cardService : cardServices) {
                map.put(cardService.getUserType(), cardService);
            }
        }
    }


    public Double ss(String userType, Double price) {

        CardService cardService = map.get(userType);
        if (cardService != null) {
            return cardService.sale(price);
        }
        return price;
    }
}
