package com.example.algorithm;

/**
 * @author Wang Yang
 * @date 2020/4/5 11:09
 */
public class Utils {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
