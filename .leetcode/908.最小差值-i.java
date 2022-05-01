/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        int maxNum = Integer.MIN_VALUE,minNum = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            maxNum = Math.max(maxNum, nums[i]);
            minNum = Math.min(nums[i], minNum);
        }
        maxNum -= k;
        minNum += k;
        if(maxNum <= minNum)return 0;
        return maxNum - minNum;
    }
}
// @lc code=end

