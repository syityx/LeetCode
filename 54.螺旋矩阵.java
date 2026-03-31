/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        // Integer[] res = new Integer[(r + 1) * (b + 1)];
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) list.add(matrix[t][i]); // left to right
            if (++t > b) break;
            for (int i = t; i <= b; i++) list.add(matrix[i][r]); // top to bottom
            if (l > --r) break;
            for (int i = r; i >= l; i--) list.add(matrix[b][i]); // right to left
            if (t > --b) break;
            for (int i = b; i >= t; i--) list.add(matrix[i][l]); // bottom to top
            if (++l > r) break;
        }
        return list;
    }
}
// @lc code=end

