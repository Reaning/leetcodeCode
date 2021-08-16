/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int begin = 10005, end = -1,n = prices.length;
        int ans = 0;
        for(int i = 0; i < n;i++){
            if(prices[i] < begin){
                begin = prices[i];
                end = prices[i];
            }
            if(prices[i] > end)end = prices[i];
            // System.out.println(end +" "+begin);
            ans = Math.max(ans, end - begin);
        }
        return ans;
    }
}
// @lc code=end

