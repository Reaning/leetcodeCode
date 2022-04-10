import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0;i < nums.length - 2;i++){
            while(i > 0 && nums[i] == nums[i - 1] && i < nums.length - 2)i++;
            int left = i + 1,right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp == 0){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(temp > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

