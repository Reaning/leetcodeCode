import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2206 lang=java
 *
 * [2206] 将数组划分成相等数对
 */

// @lc code=start
class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int t = 0;
        int n = nums.length;
        if (n % 2 == 1)return false;
        for(int i = 0;i < n;i++){
            t++;
            if(t == 2){
                if(nums[i] != nums[i - 1]){
                    return false;
                }
                t = 0;
            }
        }
        return true;
    }
}
// @lc code=end

