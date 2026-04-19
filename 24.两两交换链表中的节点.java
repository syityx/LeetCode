/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start

import java.util.ArrayDeque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (head != null && head.next != null) {
        ListNode first = head;
        ListNode second = head.next;

        // 交换
        prev.next = second;
        first.next = second.next;
        second.next = first;

        // 移动指针
        prev = first;
        head = first.next;
    }
    return dummy.next;
}
}
// @lc code=end

