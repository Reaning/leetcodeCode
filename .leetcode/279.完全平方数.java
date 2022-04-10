/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0;i <= n;i++)dp[i] = Integer.MAX_VALUE;
        int num = (int)Math.sqrt(n);
        dp[0] = 0;
        for(int i = 1;i <= num;i++){
            for(int j = i * i;j <= n;j++){
                if(dp[j - i * i] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

