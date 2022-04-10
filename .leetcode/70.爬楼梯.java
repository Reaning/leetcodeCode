/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 0;i < n;i++){
            if(i + 1 < n)dp[i + 1] += dp[i];
            if(i + 2 < n)dp[i + 2] += dp[i];
        }
        return dp[n - 1];
    }
}
// @lc code=end

