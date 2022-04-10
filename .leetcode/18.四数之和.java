import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>ans = new LinkedList<>();
        for(int i = 0; i < nums.length - 3;i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            for(int j = i + 1;j < nums.length - 2;j++){
                if(j > i + 1 && nums[j] == nums[j - 1])continue;
                int left = j + 1,right = nums.length - 1;
                while(left < right){
                    int temp = nums[left] + nums[right] + nums[i] + nums[j];
                    if(temp == target){
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        tmp.add(nums[j]);
                        ans.add(tmp);
                        while(left < right && nums[left] == nums[left + 1])left++;
                        while(left < right && nums[right] == nums[right - 1])right--;
                        left++;
                        right--;
                    }else if(temp > target)right--;
                    else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

