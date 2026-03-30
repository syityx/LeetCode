/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start

// import java.util.HashSet;

class Solution {
    // 暴力解法，TLE
    // public int maxArea(int[] height) {
    //     int maxArea = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         for (int j = i + 1; j < height.length; j++) {
    //             maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
    //         }
    //     }
    //     return maxArea;
    // }

    // 双指针解法，时间复杂度 O(N)，空间复杂度 O(1)
    public int maxArea(int[] height){
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            // 移动较短的指针，尝试找到更高的边界
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
// @lc code=end

