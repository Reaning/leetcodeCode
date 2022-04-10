/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // int n = nums.length;
        // int result = Integer.MIN_VALUE;
        // int temp = 0;
        // for(int i = 0; i < n;i++){
        //     temp += nums[i];
        //     result = Math.max(result, temp);
        //     if(temp < 0){
        //         temp = 0;
        //     }
        // }
        // return result;
        int n = nums.length;
        int[] dp = new int[n + 1];
        // for(int i = 0;i <= n;i++)dp[i] = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i <= n;i++){
            int temp = nums[i - 1] + dp[i - 1];
            if(temp < nums[i - 1]){
                dp[i] = nums[i - 1];
            }else{
                dp[i] = temp;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end

