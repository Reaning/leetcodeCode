/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int temp = 0;
        int pre = nums[0];
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > pre){
                temp++;
                ans = Math.max(ans, temp);
            }else{
                temp = 1;
            }
            pre = nums[i];
        }
        return ans;
    }
}
// @lc code=end

