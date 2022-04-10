/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 1,right = 1;
        for(int i = 1;i < n;i++)right *= nums[i];
        for(int i = 0;i < n;i++){
            ans[i] = left * right;
            left *= nums[i];
            if(i + 1 < n){
                if(nums[i + 1] == 0){
                    right = 1;
                    for(int j = i + 2;j < n; j++){
                        right *= nums[j];                        
                    }
                }
                else right /= nums[i + 1];
            }
        }
        return ans;
    }
}
// @lc code=end

