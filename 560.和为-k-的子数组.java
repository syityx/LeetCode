/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和数组: s[i] 表示前 i 个元素之和（s[0] = 0）
        // 任意子数组 [l, r] 的和 = s[r + 1] - s[l]
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        // cnt[x] 表示前面出现过多少个前缀和等于 x
        // initialCapacity = n + 1, loadFactor = 1，减少扩容带来的常数开销
        Map<Integer, Integer> cnt = new HashMap<>(n + 1, 1);

        int ans = 0;
        for (int sj : s) {
            // 需要找到之前有多少个前缀和 si，使 sj - si = k，即 si = sj - k
            // 这些 si 的个数就是以当前位置结尾、和为 k 的子数组个数
            ans += cnt.getOrDefault(sj - k, 0);

            // 将当前前缀和加入计数，供后续位置使用
            cnt.put(sj, cnt.getOrDefault(sj, 0) + 1);
        }

        // 时间复杂度: O(n)
        // 1) 构造前缀和 O(n)
        // 2) 遍历前缀和并在哈希表中查询/更新（均摊 O(1)）共 O(n)
        // 空间复杂度: O(n)
        // 1) 前缀和数组 s 占 O(n)
        // 2) 哈希表 cnt 最多存 O(n) 个不同前缀和
        return ans;
    }
}
// @lc code=end

