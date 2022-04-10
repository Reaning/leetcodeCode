import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> ans = new LinkedList<>();
    List<String>temp = new LinkedList<>();
    public boolean isReverse(char[] arr,int start,int end){
        while(start < end){
            if(arr[start++] != arr[end--])return false;
        }
        return true;
    }
    public void dfs(int pre,int start,String s,char[] arr){
        if(start == s.length()){
            // if(start == pre){
                ans.add(new LinkedList<>(temp));
            // }
            return;
        }
        dfs(pre, start + 1, s, arr);
        if(isReverse(arr, pre, start)){
            temp.add(s.substring(pre, start + 1));
            dfs(start + 1, start + 1, s, arr);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();        
        dfs(0, 0, s, arr);
        return ans;
    }
}
// @lc code=end

