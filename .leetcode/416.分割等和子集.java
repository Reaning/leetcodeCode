import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0)return false;
        int target = sum / 2;
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for(int i = 0;i < n;i++){
            for(int j = target; j >= 0;j--){
                if(j - nums[i] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[sum / 2] == sum / 2;
    }
}
// @lc code=end

