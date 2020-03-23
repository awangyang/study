package com.example.leetcode;

/**
 * @author Wang Yang
 * @date 2020/3/13 19:49
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1 == null ? 0 : nums1.length;
        int l2 = nums2 == null ? 0 : nums2.length;
        int length = l1 + l2;

        int[] arr = new int[length / 2 + 1];

        int s = length % 2;

        for (int i = 0, n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE, n1Index = 0, n2Index = 0; i < arr.length; i++) {
            if (nums1 != null && n1Index < nums1.length) {
                n1 = nums1[n1Index];
            }
            if (nums2 != null && n2Index < nums2.length) {
                n2 = nums2[n2Index];
            }
            if (n1 > n2) {
                arr[i] = n2;
                if (++n2Index >= l2) {
                    //n1Index++;
                    n2 = Integer.MAX_VALUE;
                }
            } else if (n1 < n2) {
                arr[i] = n1;
                if (++n1Index >= l1) {
                    //n2Index++;
                    n1 = Integer.MAX_VALUE;
                }
            } else {
                arr[i] = n1;
                if (n1Index + 1 == l1) {
                    n1Index++;
                    n1 = Integer.MAX_VALUE;
                } else {
                    n1Index++;
                }
            }
        }
        if (s == 0) {
            return (arr[arr.length - 1] + arr[arr.length - 1 - 1]) / 2.0;
        } else {
            return arr[arr.length - 1];
        }
    }
}
