/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //状态一：买入股票(今天买入或者之前就买入了)
        //状态二：之前卖出股票，度过了冷冻期,今天处于卖出股票状态
        //状态三：卖出股票
        //状态四：冷冻期未过，不能买入股票
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for(int i = 1;i < n;i++){
            //1.保持前一天买入股票的状态
            //2.前一天是冷冻期,dp[i - 1][3] - price[i]
            //3.前一天是保持卖出股票状态(冷冻期已过)
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            //1.前一天不是冷冻期，保持前一天的状态
            //2.前一天是冷冻期
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][3]);
            //1.昨天是买入状态，今天卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
            //1.昨天是卖出状态
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][3], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}
// @lc code=end

