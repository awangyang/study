package com.example.algorithm;

/**
 * @author Wang Yang
 * @date 2020/4/5 11:09
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3, 4, 9, 7, 6};
        sort(arr);
        Utils.print(arr);
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    Utils.swap(arr, i, j);
                }
            }
        }
    }

    static void findMax(int[] arr ,int n){}
    

}
