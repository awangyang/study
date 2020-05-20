package com.example.algorithm;

import java.util.Random;

/**
 * @author wangyang
 * @date 2020/05/20
 */
public abstract class AbstractSortTest {


    public void test(int[] arr) {
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public abstract void sort(int[] arr);


}
