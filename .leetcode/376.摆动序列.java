/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1)return n;
        int pre = 0;
        int ans = 1;
        for(int i = 0;i < n - 1;i++){
            int cur = nums[i + 1] - nums[i];
            if((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)){
                ans++;
                pre = cur;
            }
        }
        return ans;
    }
}
// @lc code=end

