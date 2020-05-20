package com.example.algorithm;

/**
 * @author Wang Yang
 * @date 2020/4/5 11:09
 */
public class BubbleSort extends AbstractSortTest {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3, 4, 9, 7, 6};
        new BubbleSort().sort(arr);
        Utils.print(arr);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[i] > arr[j]) {
                    Utils.swap(arr, i, j);
                }
            }
        }
    }
}
