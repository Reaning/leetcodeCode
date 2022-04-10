import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    void dfs(int n,boolean[] visited,int[] nums){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                temp.add(nums[i]);
                visited[i] = true;
                dfs(n, visited, nums);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        dfs(n, visited, nums);   
        return ans;
    }
}
// @lc code=end

