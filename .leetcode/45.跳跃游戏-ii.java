/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 0;i < n;i++){
            for(int j = 1;j <= nums[i];j++){
                if(i + j < n){
                    dp[i + j] = Math.min(dp[i + j],dp[i] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

