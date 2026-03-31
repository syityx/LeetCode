/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> visited = new HashMap<>();
        for (ListNode p = headA; p != null; p = p.next) {
            visited.put(p, true);
        }
        for (ListNode q = headB; q != null; q = q.next) {
            if (visited.containsKey(q)) {
                return q;
            }
        }
        return null;
    }
}
// @lc code=end

