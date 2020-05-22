package com.example.algorithm;

/**
 * @author wangyang
 * @date 2020/05/21
 */
public class QuickSort extends AbstractSortTest {
    public static void main(String[] args) {
        int[] arr = {9, 2, 8, 1, 3, 4, 5, 7, 6};
        new QuickSort().sort(arr);
        Utils.print(arr);
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    private void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //1.将中间的那个值设置为基准值
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            //2.如果右边的数字比我们的基准值大，说明符合要求，那么我们就将下标前移
            while (arr[r] > pivot) {
                r--;
            }
            //3.如果左边的数字比我们的基准值小，说明符合要求，那么我们就将下标后移
            while (arr[l] < pivot) {
                l++;
            }
            //4.因为前面在移动下标，为了避免移动过头，需要设置对应的跳出while循环
            if (l >= r) {
                break;
            }
            //5.拿到我们两个不符合的数字，并且完成交换
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            //6.这两条语句，目的是为了让与基准值相同的数据，不断地向中间靠拢
            //一旦这两条if语句中有一条被执行了，那么上面地while循环就会有一个不会被执行到
            // 每一次的交换数字都是为一个不符合规范的数字，一个与基准值相同的数字，继而达到了基准值向中间靠拢的目的
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //7.防止栈溢出
        //添加此句的目的是为了，递归排序的时候，将我们的基准值抛开，不然会进入死循环
        if (l == r) {
            l++;
            r--;
        }
        //8.左边进行递归排序
        if (left < r) {
            quickSort(arr, left, r);
        }
        //9.右边进行递归排序
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
