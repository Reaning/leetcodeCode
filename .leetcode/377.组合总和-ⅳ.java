/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        int n = nums.length;
        dp[0] = 1;
        for(int i = 1;i <= target;i++){
            for(int j = 0;j < n;j++){
                if(i - nums[j] >= 0)dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
// @lc code=end

