/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int temp = 0,left = 0;
        for(int right = 0;right < n;right++){
            temp += nums[right];
            while(temp >= target && left <= right){
                ans = Math.min(ans, right - left + 1);
                temp -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
}
// @lc code=end

