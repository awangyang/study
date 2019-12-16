package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author wangyang
 * @date 2019/12/16
 */
public class RedisTest {

    @Autowired
    private static RedisTemplate<String, String> redisTemplate;


    public static void main(String[] args) {


        redisTemplate.opsForHash().put("key", "field", "123");
        redisTemplate.expire("key", 100, TimeUnit.SECONDS);


    }
}
