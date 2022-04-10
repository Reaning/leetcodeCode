import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    int sum;
    public void dfs(int start,int[] candidates,int target){
        if(sum == target){
            ans.add(new LinkedList<>(temp));
            return;
        }
        if(start >= candidates.length)return;
        if(target - sum < candidates[start])return;
        dfs(start + 1, candidates, target);
        int n = (target - sum)/candidates[start];
        sum += n * candidates[start];
        for(int i = 0; i < n;i++)temp.add(candidates[start]);
        for(int i = 0;i < n;i++){
            dfs(start + 1, candidates, target);
            sum -= candidates[start];
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return ans;
    }
}
// @lc code=end

