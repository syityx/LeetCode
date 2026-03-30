/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> need_p = new HashMap<>();
        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray()) {
            need_p.put(c, need_p.getOrDefault(c, 0) );
        }
        HashMap<Character, Integer> need_s = new HashMap<>();
        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray()) {
            need_s.put(c, need_p.getOrDefault(c, 0) );
        }
        for (char c : p.toCharArray()) {
            need_p.put(c, need_p.getOrDefault(c, 0) + 1);
        }

        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // System.out.println("right: " + right);
            char c = s.charAt(right);
            need_s.put(c, need_s.getOrDefault(c, 0) + 1);

            left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }

            if (need_s.equals(need_p)) {
                
                result.add(left);
            }

            char cc = s.charAt(left);
            need_s.put(cc, need_s.getOrDefault(cc, 0) - 1);
            // System.err.println("need_p: " + need_p + " need_S: " + need_s);

            // while (need_s.getOrDefault(c, 0) > need_p.getOrDefault(c, 0)) {
            //     char left_c = s.charAt(left);
            //     need_s.put(left_c, need_s.get(left_c) - 1);
            //     left++;
            // }
        }

        return result;
    }
}
// @lc code=end

// 手搓，使用一个包含24字母的hashmap，记录滑动窗口中每个char出现的次数，判断每个map是否相等。
// 复杂度分析：时间复杂度为O(N*M)，其中N是字符串s的长度，M是字符串p的长度。空间复杂度为O(1)，因为hashmap的大小是固定的（26个字母）。