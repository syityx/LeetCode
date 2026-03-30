/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // "eat" -> ['e', 'a', 't'] -> "aet"
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            // 等价以下代码
            // if(map.containsKey(key)){
            //     map.get(key).add(str);
            // }else{
            //     List<String> c = new ArrayList<>();
            //     c.add(str);
            //     map.put(key, c);
            // }
        }

        return new ArrayList<>(map.values());
    }
}
// @lc code=end

/**
 * 将排序后的str作为map的key，value是一个list，存储所有排序后相同的string。最后返回map的value即可。
 * 复杂度分析：时间复杂度为O(N*M*logM)，其中N是字符串数组的长度，M是字符串的平均长度。空间复杂度为O(N*M)。
 */
