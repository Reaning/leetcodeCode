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
        if(Math.abs(target) > sum)return 0;
        int diff = sum - target;
        if(diff % 2 == 1)return 0;
        target = diff / 2;
        int[] dp = new int[target + 1];
        int n = nums.length;
        dp[0] = 1;
        for(int i = 0;i < n;i++){
            for(int j = target; j >= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
// @lc code=end

