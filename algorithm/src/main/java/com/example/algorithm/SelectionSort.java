package com.example.algorithm;

/**
 * @author Wang Yang
 * @date 2020/4/5 11:09
 */
public class SelectionSort extends AbstractSortTest {

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3, 4, 9, 7, 6};
        new SelectionSort().sort(arr);
        Utils.print(arr);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            Utils.swap(arr, i, minIndex);
        }
    }
}
