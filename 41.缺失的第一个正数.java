/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] - 1 == i || nums[i] <= 0 || nums[i] >= n){
                i++;
                continue;
            }
            i += swap(nums, i, nums[i] - 1);
        }

        for(int j = 0; j < n; j++){
            if(nums[j] != j + 1){
                return j+1;
            }
        }
        return nums[n-1] > 0 ? n+1 : 1; 
    }
    public int swap(int[] nums, int a, int b){
        if (nums[a] == nums[b]) {
            return 1;
        }
        int temp = nums[a] + nums[b];
        nums[a] = temp - nums[a];
        nums[b] = temp - nums[b];
        return 0;
    }
}
// @lc code=end

