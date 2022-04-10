import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>>ans = new ArrayList<>();
    List<Integer>temp = new ArrayList<>();
    public void dfs(int start,int n,int k){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start + 1;i <= n;i++){
            temp.add(i);
            dfs(i, n, k);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        dfs(0, n, k);
        return ans;
    }
}
// @lc code=end

