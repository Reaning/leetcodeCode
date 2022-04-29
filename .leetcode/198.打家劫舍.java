/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int[]dp = new int[n];
        for(int i = 0;i < n;i++)dp[i] = nums[i];
        for(int i = 0;i < n;i++){
            if(i + 2 < n)dp[i + 2] = Math.max(dp[i + 2], dp[i] + nums[i + 2]);
            if(i + 3 < n)dp[i + 3] = Math.max(dp[i + 3], dp[i] + nums[i + 3]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
// @lc code=end

