/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];
        for(int i = 0;i < n - 1;i++){
            dp1[i] = Integer.MIN_VALUE;
            dp2[i] = Integer.MIN_VALUE;
        }
        dp1[0] = nums[0];
        dp1[1] = nums[1];
        dp2[0] = nums[1];
        dp2[1] = nums[2];
        for(int i = 0;i < n - 1;i++){
            if(i + 2 < n - 1)dp1[i + 2] = Math.max(dp1[i + 2], dp1[i] + nums[i + 2]);
            if(i + 3 < n - 1){
                dp1[i + 3] = Math.max(dp1[i + 3], dp1[i] + nums[i + 3]);
            }
        }
        for(int i = 1;i < n;i++){
            if(i + 2 < n){
                dp2[i + 1] = Math.max(dp2[i + 1], dp2[i - 1] + nums[i + 2]);
            }
            if(i + 3 < n){
                dp2[i + 2] = Math.max(dp2[i + 2], dp2[i - 1] + nums[i + 3]);
            }
        }
        return Math.max(dp1[n - 2], Math.max(dp2[n - 2], Math.max(dp1[n - 3], dp2[n - 3])));
    }
}
// @lc code=end

