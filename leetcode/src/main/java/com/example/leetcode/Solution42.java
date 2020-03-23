package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Yang
 * @date 2020/3/13 19:47
 */
public class Solution42 {
    public static int trap(int[] height) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int now = height[i];
            int h = 0;
            if (now >= max) {
                h = max * (i - maxIndex);
                for (int j = maxIndex; j < i; j++) {
                    h -= height[j];
                }
                max = now;
                maxIndex = i;
                list.clear();
            }
            list.add(now);
            count += h;
        }
        max = 0;
        maxIndex = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int now = list.get(i);
            int h = 0;
            if (now >= max) {
                h = max * (maxIndex - i);
                for (int j = i; j < maxIndex; j++) {
                    h -= list.get(j + 1);
                }
                max = now;
                maxIndex = i;
            }
            count += h;
        }
        return count;
    }

    public static int trap2(int[] height) {
        int index = getMaxIndex(height);
        int count = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <= index; i++) {
            int now = height[i];
            if (now >= max) {
                count += max * (i - maxIndex);
                for (int j = maxIndex; j < i; j++) {
                    count -= height[j];
                }
                max = now;
                maxIndex = i;
            }
        }
        max = 0;
        maxIndex = 0;
        for (int i = height.length; i > index; i--) {
            int now = height[i - 1];
            if (now >= max) {
                count += max * (maxIndex - i);
                for (int j = i; j < maxIndex; j++) {
                    count -= height[j];
                }
                max = now;
                maxIndex = i;
            }
        }
        return count;
    }

    public static int trap4(int[] height) {
        int count = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int now = height[i];
            if (now >= max) {
                count += max * (i - maxIndex);
                for (int j = maxIndex; j < i; j++) {
                    count -= height[j];
                }
                max = now;
                maxIndex = i;
            }
        }
        max = 0;
        int index = maxIndex;
        maxIndex = 0;
        for (int i = height.length - 1; i >= index; i--) {
            int now = height[i];
            if (now >= max) {
                count += max * (maxIndex - i);
                for (int j = i; j < maxIndex; j++) {
                    count -= height[j + 1];
                }
                max = now;
                maxIndex = i;
            }
        }
        return count;
    }


    public static int trap3(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int index = getMaxIndex(height);
        int num = height.length - 1;
        int[] arr = new int[height.length - index];
        for (int i = num; i >= index; i--) {
            arr[num - i] = height[i];
        }
        return getCount(height, index + 1) + getCount(arr, arr.length);
    }

    private static int getCount(int[] height, int index) {
        int count = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < index; i++) {
            if (height[i] >= max) {
                count += max * (i - maxIndex);
                for (int j = maxIndex; j < i; j++) {
                    count -= height[j];
                }
                max = height[i];
                maxIndex = i;
            }
        }
        return count;
    }

    private static int getMaxIndex(int[] height) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        //0,1,0,2,1,0,1,3,2,1,2,1
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] arr = {4,2,3};
//        int[] arr = {};
//
        System.out.println(trap4(arr));
//        int a = 10;
//        int b = 20;
//        System.out.println("a=" + a * 10);
//        System.out.println("b=" + b * 10);
    }


    private static void method1(int a, int b) {
        System.out.println("a=" + a * 10);
        System.out.println("b=" + b * 10);
        System.exit(0);

    }
}
