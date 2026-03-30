import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c)) {
                left = Math.max(left, lastIndex.get(c) + 1);
                // left = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, right);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
// @lc code=end
/**
 * 使用滑动窗口，维护一个字符到其最后出现位置的映射
 * 当遇到重复字符时，更新左边界left为重复字符上次出现位置的下一位
 * 每次更新右边界right时，计算当前窗口长度并更新答案
 * 最后返回最长子串的长度
 */