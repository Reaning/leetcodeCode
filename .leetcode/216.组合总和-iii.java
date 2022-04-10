import java.lang.Thread.State;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    int sum;
    public void dfs(int start,int k,int n){
        if(temp.size() == k){
            if(sum == n){
                ans.add(new LinkedList<>(temp));
            }
            return;
        }
        if(start > 9)return;
        if(n - sum < start)return;
        dfs(start + 1, k, n);
        temp.add(start);
        sum += start;
        dfs(start + 1, k, n);
        temp.remove(temp.size() - 1);
        sum -= start;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n);
        return ans;
    }
}
// @lc code=end

