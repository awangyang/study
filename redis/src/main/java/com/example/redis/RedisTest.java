package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wangyang
 * @date 2019/12/16
 */
public class RedisTest {

    @Autowired
    private static RedisTemplate redisTemplate;

    public static void main(String[] args) {
//        redisTemplate.opsForHash().p
//        redisTemplate.opsForValue().
//                redisTemplate.expire()
    }
}
