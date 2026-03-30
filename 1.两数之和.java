import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (indexByValue.containsKey(need)) {
                return new int[] { 
                    indexByValue.get(need), i 
                };
            }
            indexByValue.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

/**
 * 遍历数组，记录每个数的索引。对于每个数，计算出需要的另一个数
 * 当另一个数存在于记录中时，返回两个数的索引
 * 
 * indexByValue中把num[i]作为key，i作为value
 * 这样当需要另一个数时，可以直接通过indexByValue.get(need)获取到另一个数的索引 
 */
