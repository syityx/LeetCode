/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除了自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1 - i;
            // left[i] = (i == 0) ? 1 : left[i - 1] * nums[i - 1];
            right[j] = (j == nums.length - 1) ? 1 : right[j + 1] * nums[j + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = (i == 0) ? 1 : left[i - 1] * nums[i - 1];
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
// @lc code=end

