import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1,right = -1;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(nums[i] < max){
                right = i;
            }else{
                max = nums[i];
            }
            if(nums[n - 1 - i] > min){
                left = n - 1 - i;
            }else{
                min = nums[n - 1 - i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
// @lc code=end

