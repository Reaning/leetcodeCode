import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i < n;i++)dp[i] = 1;
        for(int i = 1;i < n;i++){
            for(int j = i;j >= 0;j--){
                if(nums[i] > nums[j])dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

