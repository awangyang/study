package com.example.algorithm;

/**
 * @author Wang Yang
 * @date 2020/4/5 11:09
 */
public class InsertionSort extends AbstractSortTest {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3, 4, 9, 7, 6};
        new InsertionSort().sort(arr);
        Utils.print(arr);
    }
    @Override
    public void sort(int[] arr) {
        int temp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
