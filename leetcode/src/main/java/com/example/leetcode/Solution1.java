package com.example.leetcode;

import java.util.Arrays;

/**
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author: WangYang
 * @date: 2019-10-10 23:06:14
 */
public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        int temp = -1;
        int[] result =new int[2];
        for (int i = 0; i  < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(target == (nums[i] + nums[j])){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }


//    public static void main(String[] args) {
//        List<Integer> linkedList = new ArrayList<>();
//
//        int num = 100;
//
//        for (int i = 0; i <= num; i++) {
//            linkedList.add(i);
//        }
//        List<Integer> list = new ArrayList<>(128);
//
//        while (linkedList.size() != 1) {
//            for (int i = 1; i <= linkedList.size(); i++) {
//                if (i % 2 == 1) {
//                    list.add(linkedList.get(i - 1));
//                }
//            }
//            for (Integer integer : list) {
//                linkedList.remove(integer);
//            }
//            list.clear();
//        }
//        System.out.println(linkedList);
//    }
}
