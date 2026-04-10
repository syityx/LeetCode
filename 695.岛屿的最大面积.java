/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    int s = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if ((grid[i][j]) == 1) {
                    s = Math.max(dfs(grid, i, j), s);
                }
            }
        }
        return s;
    }

    public int dfs(int[][] grid, int m, int n){
        if(!(m>=0 && m<grid.length && n>=0 && n<grid[0].length)){
            return 0;
        }
        if (grid[m][n] != 1) {
            return 0;
        }
        grid[m][n] = 2;
        return dfs(grid, m+1, n) +
        dfs(grid, m, n+1) +
        dfs(grid, m-1, n) +
        dfs(grid, m, n-1) + 1;
    }
}
// @lc code=end

