import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3)return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = n - 1; i >= 2; i--){
            int left = 0,right = i - 1;
            int temp = nums[i];
            while(left < right){
                if(temp < nums[left] + nums[right]){
                    while(right > left && nums[right] + nums[left] > temp){
                        ans++;
                        right--;
                    }
                }
                left++;
                right = i - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

