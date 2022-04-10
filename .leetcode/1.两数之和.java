import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            mp.put(nums[i],i);
        }
        for(int i = 0;i < nums.length;i++){
            if(mp.containsKey(target - nums[i])){
                int temp = mp.get(target - nums[i]);
                if(temp!= i)
                    return new int[]{i,temp};
            }
        }
        return new int[0];
    }
}
// @lc code=end

