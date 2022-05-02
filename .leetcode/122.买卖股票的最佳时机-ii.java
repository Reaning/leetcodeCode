import javax.print.attribute.standard.NumberUpSupported;

/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        //dp[0]为买了当前的股票
        dp[0] = -prices[0];
        //dp[1]为把手上的股票给出了
        dp[1] = 0;
        for(int i = 1;i < n;i++){
            //比较上一状态（持有股票），再持有当前股票的状态，哪个更多钱
            //如果卖股票亏了，dp[1] - price会比dp[0]要大，所以会替代dp[0](买了亏的股票)
            //更新之前dp[1]把买的股票卖了，相当于没有买之前那个股票
            //更新:比较不买之前的股票和买当前的股票，哪个钱更多
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            //如果是当前股票更有钱，就保存当前状态
            //如果是之前那个股票更值钱，就得到之前股票的钱
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
}
// @lc code=end

