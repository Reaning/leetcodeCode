import javax.print.attribute.standard.NumberUpSupported;

/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 0;i < prices.length - 1;i++){
            ans += Math.max(prices[i + 1] - prices[i], 0);
        }
        return ans;
    }
}
// @lc code=end

