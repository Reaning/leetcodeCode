/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for(int right = 0;right < n;right++){
            while(right < n && nums[right] == val){
                right++;
            }
            if(right < n){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left++] = temp;
            }
        }
        return left;
    }
}
// @lc code=end

