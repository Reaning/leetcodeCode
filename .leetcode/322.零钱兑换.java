import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int[]dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int j = 0; j < coins.length;j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }else{
                    break;
                }
            }
        }
        return dp[amount] == 0? -1:dp[amount];
    }
}
// @lc code=end

