import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n - 2;i >= 0;i--){
            if(nums[i] < nums[i + 1]){
                int j = n - 1;
                // System.out.println(i + " "+j);
                while(nums[j] <= nums[i])j--;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                System.out.println(nums[j]);
                Arrays.sort(nums, i + 1, n);
                break;
            }
            else if(i == 0)Arrays.sort(nums);
        }
    }
}
// @lc code=end

