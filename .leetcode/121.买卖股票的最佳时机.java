/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0)return 0;
        int[][]dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }
}
// @lc code=end

