package com.example.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangyang
 * @date 2019/09/04
 */
public class Solution3 {


    public static int lengthOfLongestSubstring2(String s) {

        int length = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i - 1; j >= start; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    start = j + 1;
                }
            }
            length = Math.max(i + 1 - start, length);
        }
        return length;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        // 不重复子段起始索引
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = pos; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果子段中有重复的字符 起始索引为当前子段重复字符的下一位
                    pos = j + 1;
                }
            }
            // 最大长度为 当前索引 + 1 - 起始索引
            maxLength = Math.max(i + 1 - pos, maxLength);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {

//        Map<Character, Integer> map = new ConcurrentHashMap<>(16);
        List<Character> list = new ArrayList<>();
        char[] chas = s.toCharArray();
        int length = 0;
        for (int i = 0; i < chas.length; i++) {
            if (list.contains(chas[i])) {
                Iterator<Character> iterator = list.iterator();
                Character c;
                while (iterator.hasNext()) {
                    c = iterator.next();
                    if (c == chas[i]) {
                        iterator.remove();
                        break;
                    }
                    iterator.remove();
                }
            }
            list.add(chas[i]);
            length = length < list.size() ? list.size() : length;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcfbsfdgsdg"));
        System.out.println(lengthOfLongestSubstring1("bbb"));
        System.out.println(lengthOfLongestSubstring1("abcd"));
        System.out.println(lengthOfLongestSubstring1("abb"));
        System.out.println(lengthOfLongestSubstring1("abbcv"));
        System.out.println(lengthOfLongestSubstring1("abcc"));
        System.out.println(lengthOfLongestSubstring1(""));
        System.out.println(lengthOfLongestSubstring1("a"));
    }


}
