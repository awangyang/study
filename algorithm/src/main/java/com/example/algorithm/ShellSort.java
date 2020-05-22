package com.example.algorithm;

/**
 * @author wangyang
 * @date 2020/05/20
 */
public class ShellSort extends AbstractSortTest {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3, 4, 9, 7, 6};
        new ShellSort().sort1(arr);
        Utils.print(arr);
    }

    @Override
    public void sort(int[] arr) {
        int k = arr.length / 2;
        int temp;
        int j;
        while (k >= 1) {
            for (int i = k; i < arr.length; i++) {
                temp = arr[i];
                arr[i] = arr[i - k];
                for (j = i - k; j >= 0 && arr[j] > temp; j = j - k) {
                    arr[j + k] = arr[j];
                }
                arr[j + k] = temp;
            }
            k = k / 2;
        }
    }


//    /**
//     * 交换法  效率低
//     *
//     * @param arr
//     * @param k
//     */
//    private void shellSort(int[] arr, int k) {
//        for (int i = k; i < arr.length; i++) {
//            for (int j = i - k; j >= 0; j = j - k) {
//                if (arr[j] > arr[j + k]) {
//                    Utils.swap(arr, j, j + k);
//                }
//            }
//        }
//    }
//
//    /**
//     * 移动法 效率高
//     *
//     * @param arr
//     * @param k
//     */
//    private void shellSort(int[] arr, int k) {
//        int temp;
//        int j;
//        for (int i = k; i < arr.length; i++) {
//            temp = arr[i];
//            arr[i] = arr[i - k];
//            for (j = i - k; j >= 0 && arr[j] > temp; j = j - k) {
//                arr[j + k] = arr[j];
//            }
//            arr[j + k] = temp;
//        }
//    }


    public void sort1(int[] arr) {
        //int[] arr = {5, 2, 8, 1, 3, 4, 9, 7, 6};
        //int k = arr.length / 2;
        int temp;
        int j;
        for (int i = 4; i < arr.length; i++) {
            temp = arr[i];
            arr[i] = arr[i - 4];
            for (j = i - 4; j >= 0 && arr[j] > temp; j = j - 4) {
                arr[j + 4] = arr[j];
            }
            arr[j + 4] = temp;
        }

        for (int i = 2; i < arr.length; i++) {
            temp = arr[i];
            arr[i] = arr[i - 2];
            for (j = i - 2; j >= 0 && arr[j] > temp; j = j - 2) {
                arr[j + 2] = arr[j];
            }
            arr[j + 2] = temp;
        }


        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            arr[i] = arr[i - 1];
            for (j = i - 1; j >= 0 && arr[j] > temp; j = j - 1) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }

    }
}
