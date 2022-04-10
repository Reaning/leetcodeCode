/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for(int i = 1;i <= m;i++){
            for(int j = 1; j <= n;j++){
                if(obstacleGrid[i - 1][j - 1] != 0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

