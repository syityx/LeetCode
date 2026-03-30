/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 处理k大于数组长度的情况
        reverse(nums, 0, nums.length - 1); // 反转整个数组 O(n)
        reverse(nums, 0, k - 1); // 反转前k个元素 O(k)
        reverse(nums, k, nums.length - 1); // 反转剩余元素 O(n-k)
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
// @lc code=end

/**
 * 三次翻转
 * 时间O(n),空间O(1)
 */