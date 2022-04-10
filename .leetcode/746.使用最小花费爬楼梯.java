/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 2];
        for(int i = 3; i < n + 2;i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 2], dp[i - 2] + cost[i - 3]);
        }
        return dp[n + 1];
    }
}
// @lc code=end

