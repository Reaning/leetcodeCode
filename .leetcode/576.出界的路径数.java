import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class Solution {
    public int[][] direction ={{1,0},{-1,0},{0,1},{0,-1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][]dp = new int[m][n];
        int[][]temp = new int[m][n];
        int mod = 1000000007;
        for(int i = 0;i < m;i++){
            temp[i] = dp[i].clone();
        }
        int ans = 0;
        dp[startRow][startColumn] = 1;
        while(maxMove > 0){
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    if(dp[i][j] >= 1){
                        for(int k = 0;k < 4;k++){
                            int r = i + direction[k][0],c = j + direction[k][1];
                            if(r >= 0 && c >= 0 && r < m && c < n){
                                temp[r][c] += dp[i][j];
                            }
                            else{
                                ans += dp[i][j];
                            }
                        }
                    }
                }
            }
            // System.out.println(ans);
            for(int i = 0;i < m;i++){
                dp[i] = temp[i].clone();
            }
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    temp[i][j] = 0;
                }
            }
            ans = ans % mod;
            maxMove--;
        }
        return ans;
    }
}
// @lc code=end

