package com.example.guava;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Yang
 * @date 2020/3/2 19:27
 */
public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<>(128);
//48690
//        map.put("123", "abc");

//        System.out.println(10 & 15);
//        System.out.println(11 & 15);
//        System.out.println(12 & 15);
//        System.out.println(13 & 15);
//        System.out.println(14 & 15);
//        System.out.println(126 & 31);
//        System.out.println(126 & 32);
//
//        System.out.println(10 & 31);
//        System.out.println(11 & 31);
//        System.out.println(12 & 31);
//        System.out.println(13 & 31);
//        System.out.println(14 & 31);
//        System.out.println("-----------------------------");
//
//        System.out.println(1654 & 15);
//        System.out.println(112341 & 15);
//        System.out.println(15432 & 15);
//        System.out.println(13654 & 15);
//        System.out.println(14434 & 15);
//        System.out.println("--");
//        System.out.println(1654 & 31);
//        System.out.println(112341 & 31);
//        System.out.println(15432 & 31);
//        System.out.println(13654 & 31);
//        System.out.println(14434 & 31);
//        System.out.println("--");
//        System.out.println(1654 & 63);
//        System.out.println(112341 & 63);
//        System.out.println(15432 & 63);
//        System.out.println(13654 & 63);
//        System.out.println(14434 & 63);

        System.out.println(tableSizeFor(25 + (25 >>> 1) + 1));
        System.out.println(tableSizeFor(25 + (25 >>> 1) + 1));

    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
