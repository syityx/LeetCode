/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序开销: O(n log n)
        Arrays.sort(nums);
        ArrayList<List<Integer>> arrayList = new ArrayList<>();

        // 外层最多执行 n 次
        for (int k = 0 ; k < nums.length - 2; ) {
            int left = k + 1;
            int right = nums.length - 1;

            // 对固定的 k，left 和 right 单调移动，总开销 O(n)
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum == 0) {
                    arrayList.add(Arrays.asList(nums[k], nums[left], nums[right]));
                }
                if (sum < 0) {
                    int l = nums[left];
                    // 跳过重复值；总移动次数仍计入当前轮 O(n)
                    while (left < right && nums[left] == l) {
                        left++;
                    }
                } else {
                    int r = nums[right];
                    // 跳过重复值；总移动次数仍计入当前轮 O(n)
                    while (left < right && nums[right] == r) {
                        right--;
                    }
                }
            }
            int now = nums[k];
            // 去重 k；总增量不超过 n
            while (k < nums.length - 2 && nums[k] == now) {
                k++;
            }
        }
        // 总时间复杂度: O(n^2)；额外空间复杂度: O(1)（不计返回结果）
        return arrayList;
    }
}
// @lc code=end


