package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Yang
 * @date 2020/3/13 19:56
 */
public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int ten = 0;
        ListNode root = new ListNode(0);
        ListNode r = root;
        while (l1 != null || l2 != null) {
            int vl1 = 0;
            int vl2 = 0;
            if (l1 != null) {
                vl1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                vl2 = l2.val;
                l2 = l2.next;
            }
            int v = vl1 + vl2 + ten;
            ten = v / 10;
            r.next = new ListNode(v % 10);
            r = r.next;
        }

        if (ten > 0) {
            r.next = new ListNode(1);
        }
        return root.next;

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode root;
        List<ListNode> listNodes = new ArrayList<>();
        while (true) {
            int vl1 = 0;
            int vl2 = 0;
            if (l1 != null) {
                vl1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                vl2 = l2.val;
                l2 = l2.next;
            }
            int v = vl1 + vl2;
            if (listNodes.size() > 0) {
                root = listNodes.get(listNodes.size() - 1);
                if (root != null) {
                    v += root.val;
                }
            }
            int ten = 0;
            if (v >= 10) {
                root = new ListNode(v % 10);
                ten += 1;
            } else {
                root = new ListNode(v);
            }
            if (listNodes.size() > 0) {
                listNodes.set(listNodes.size() - 1, root);
            } else {
                listNodes.add(root);
            }
            listNodes.add(new ListNode(ten));
            if (l1 == null && l2 == null) {
                break;
            }
        }

        root = listNodes.get(0);
        if (listNodes.get(listNodes.size() - 1).val == 0) {
            listNodes.remove(listNodes.size() - 1);
        }
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        return root;
    }


}
