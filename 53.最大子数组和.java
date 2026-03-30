/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    /**
     * 使用Kadane算法找到最大子数组和
     * @param nums 输入数组
     * @return 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        // res: 记录全局最大值
        int res = nums[0];
        // pre: 记录以当前位置结尾的最大子数组和
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            // 选择：继续加当前元素 或 重新开始一个新子数组
            pre = Math.max(pre + nums[i], nums[i]);
            // 更新全局最大值
            res = Math.max(res, pre);
        }
        return res;
    }
}
// @lc code=end

