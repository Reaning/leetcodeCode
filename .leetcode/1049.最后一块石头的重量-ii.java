/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for(int i = 0;i < n;i++){
            sum += stones[i];
        }
        int t = sum / 2;
        int[]dp = new int[t + 1];
        for(int i = 0;i < n;i++){
            for(int j = t;j >= stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return Math.abs(sum - 2 * dp[t]);
    }
}
// @lc code=end

