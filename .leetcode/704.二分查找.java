/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right = n;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

