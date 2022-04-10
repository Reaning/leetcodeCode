/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length;i++){
            min = Math.min(min, prices[i]);
            ans = Math.max(prices[i] - min, ans);
        }
        return ans;
    }
}
// @lc code=end

