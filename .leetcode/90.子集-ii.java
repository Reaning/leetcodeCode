import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public void dfs(int[] nums, int start){
        ans.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length;i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }
}
// @lc code=end

