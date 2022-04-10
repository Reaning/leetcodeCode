/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        dp[0] = 1;
        for(int i = 0;i < n;i++){
            for(int j = coins[i];j <= amount;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

