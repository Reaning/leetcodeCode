/*
 * @lc app=leetcode.cn id=2210 lang=java
 *
 * [2210] 统计数组中峰和谷的数量
 */

// @lc code=start
class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 1;i < n - 1;i++){
            if(nums[i] == nums[i - 1]){
                continue;
            }
            int left = nums[i - 1];
            int right = nums[i];
            int j = i + 1;
            while(j < n && nums[j] == nums[i]){
                j++;
            }
            if(j == n){
                break;
            }
            right = nums[j];
            if((nums[i] > left && nums[i] > right) || (nums[i] < left && nums[i] < right)){
                ans++;
            }
            i = j - 1;
        }
        return ans;
    }
}
// @lc code=end

