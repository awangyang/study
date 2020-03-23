package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * @author wangyang
 * @date 2019/11/05
 */
public class Solution39 {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);


        return null;
    }


    private static List<Integer> test(int[] candidates, int target, int start, List<Integer> list) {

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] < target) {
                List<Integer> list1 = new ArrayList<>();
            }
        }
        return null;
    }
}