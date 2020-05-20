package com.example.algorithm;

import java.util.Arrays;

/**
 * @author Wang Yang
 * @date 2020/4/5 11:09
 */
public class Utils {

    static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
