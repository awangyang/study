package com.example.algorithm;

/**
 * @author wangyang
 * @date 2020/05/21
 */
public class MergeSort extends AbstractSortTest {
    public static void main(String[] args) {
        int[] arr = {9, 2, 8, 1, 3, 4, 5, 7, 6};
        new MergeSort().sort(arr);
        Utils.print(arr);
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid - 1, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {


    }
}
