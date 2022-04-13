/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int count = 1;
        for(int i = 1;i < n;i++){
            if(count == 0){
                ans = nums[i];
            }
            if(nums[i] == ans){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}
// @lc code=end

