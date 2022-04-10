import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for(int i = 1;i <= amount;i++)dp[i] = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            for(int j = coins[i];j <= amount;j++){
                if(dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}
// @lc code=end

