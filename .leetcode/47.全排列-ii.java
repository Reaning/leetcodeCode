import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    void dfs(int n,int[] nums,boolean[] visited){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i < n;i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            if(visited[i] == false){
                visited[i] = true;
                temp.add(nums[i]);
                dfs(n,nums,visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        } 
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        dfs(n, nums, visited);
        return ans;
    }
}
// @lc code=end

