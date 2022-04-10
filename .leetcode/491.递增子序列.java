import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    void dfs(int[] nums,int start){
        if(temp.size() > 1){
            ans.add(new ArrayList<>(temp));
        }
        boolean[] used = new boolean[201];
        for(int i = start;i < nums.length;i++){
            if(used[nums[i] + 100])continue;
            if(temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)){
                used[nums[i] + 100] = true;
                temp.add(nums[i]);
                dfs(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return ans;
    }
}
// @lc code=end

