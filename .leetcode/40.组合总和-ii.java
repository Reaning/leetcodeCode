import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer>temp = new LinkedList<>();
    int sum;
    public void dfs(int start,int[][]a,int target){
        if(sum == target){
            ans.add(new LinkedList<>(temp));
            return;
        }
        if(sum > target || start >= a.length)return;
        dfs(start + 1, a, target);
        int n = (target - sum) / a[start][0];
        int t = Math.min(n, a[start][1]);
        sum += t * a[start][0];
        for(int i = 0;i < t;i++){
            temp.add(a[start][0]);
        }
        for(int i = 0;i < t;i++){
            dfs(start + 1, a, target);
            temp.remove(temp.size() - 1);
            sum -= a[start][0];
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer,Integer>mp = new HashMap();
        for(int i : candidates){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int[][] a = new int[mp.size()][2];
        int index = 0;
        for(Map.Entry<Integer,Integer> i : mp.entrySet()){
            a[index][0] = i.getKey();
            a[index++][1] = i.getValue();
        }
        dfs(0, a, target);
        return ans;
    }
}
// @lc code=end

