package com.example.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangyang
 * @date 2020/05/20
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(500000000);
        }
//        int[] bubble = Arrays.copyOf(arr,arr.length);
//        AbstractSortTest sortTest1 = new BubbleSort();
//        sortTest1.test(bubble);
//
//        int[] selection = Arrays.copyOf(arr,arr.length);
//        AbstractSortTest sortTest2 = new SelectionSort();
//        sortTest2.test(selection);
//
//        int[] insertion = Arrays.copyOf(arr,arr.length);
//        AbstractSortTest sortTest3 = new InsertionSort();
//        sortTest3.test(insertion);

//        int[] shell = Arrays.copyOf(arr,arr.length);
//        AbstractSortTest sortTest4 = new ShellSort();
//        sortTest4.test(shell);

        int[] quick = Arrays.copyOf(arr,arr.length);
        AbstractSortTest sortTest5 = new QuickSort();
        sortTest5.test(quick);

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(bubble));
//        System.out.println(Arrays.toString(selection));
//        System.out.println(Arrays.toString(insertion));
    }
}
