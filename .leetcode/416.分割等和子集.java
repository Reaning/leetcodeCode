import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
        }
        if(sum % 2 == 1)return false;
        int t = sum / 2;
        int[] dp = new int[t + 1];
        for(int i = 0;i < n;i++){
            for(int j = t;j - nums[i] >= 0;j--){
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[t] == t;
    }
}
// @lc code=end

