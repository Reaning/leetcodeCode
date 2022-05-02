/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0)return 0;
        int[][] dp = new int[n][2 * k + 1];
        dp[0][0] = 0;
        for(int i = 0;i < k;i++){
            dp[0][2 * i + 1] = -prices[0];
            dp[0][2 * i + 2] = 0;
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < k;j++){
                dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i - 1][2 * j] - prices[i]);
                dp[i][2 * j + 2] = Math.max(dp[i - 1][2 * j + 2], dp[i - 1][2 * j + 1] + prices[i]);
            }
        }
        return dp[n - 1][2 * k];
    }
}
// @lc code=end

