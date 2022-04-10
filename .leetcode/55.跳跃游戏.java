/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int dis = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(dis >= i){
                dis = Math.max(dis, i + nums[i]);
            }
        }
        return dis >= n - 1;
    }
}
// @lc code=end

