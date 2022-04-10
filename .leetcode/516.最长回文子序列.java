import java.util.List;

/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1;i <= n;i++)dp[i][i] = 1;
        for(int i = 1;i <= n;i++){
            for(int j = 1; i + j <= n;j++){
                if(s.charAt(j - 1) == s.charAt(i + j - 1)){
                    dp[j][i + j] = dp[j + 1][i + j - 1] + 2;
                }else{
                    dp[j][i + j] = Math.max(dp[j + 1][i + j], dp[j][i + j - 1]);
                }
            }
        }
        return dp[1][n];
    }
}
// @lc code=end

