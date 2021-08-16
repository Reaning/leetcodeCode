/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        dp[0] = 1;
        count[0] = 1;
        int length = 1;
        for(int i = 1;i < n;i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i;j++){
               if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1){
                        count[i]+=count[j];
                    }
               }
            }
            length = Math.max(dp[i], length);
        }
        int result = 0; // 统计结果 
        for (int i = 0; i < n; i++) {
            if (length == dp[i]) result += count[i];
        }
        return result;
    }
}
// @lc code=end

