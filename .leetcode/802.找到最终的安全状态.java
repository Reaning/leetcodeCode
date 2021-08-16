import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=802 lang=java
 *
 * [802] 找到最终的安全状态
 */

// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int num = n;
        int[] visited = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < n;i++){
            if(graph[i].length == 0){
                s.add(i);
                visited[i] = 1;
                num--;
                ans.add(i);
            }
        }
        if(s.isEmpty())return ans;
        int index = -1;
        while(index != num){
            index = num;
            for(int i = 0;i < n;i++){
                if(visited[i] == 0){
                    int m = graph[i].length;
                    int ptr = 0;
                    for(int j = 0;j < m;j++){
                        if(s.contains(graph[i][j])){
                            ptr++;
                        }
                    }
                    if(ptr == m){
                        s.add(i);
                        ans.add(i);
                        num--;
                        visited[i] = 1;
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
// @lc code=end

