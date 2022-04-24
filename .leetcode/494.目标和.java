import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(sum < target)return 0;
        if(Math.abs(sum - target) % 2 != 0)return 0;
        int t = Math.abs((sum - target) / 2);
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = t;i >= num;i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[t];
    }
}
// @lc code=end

