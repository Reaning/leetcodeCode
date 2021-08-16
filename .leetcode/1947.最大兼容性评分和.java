import java.util.List;

/*
 * @lc app=leetcode.cn id=1947 lang=java
 *
 * [1947] 最大兼容性评分和
 */

// @lc code=start
class Solution {
    List<List<Integer>>combine = new ArrayList<List<Integer>>();
    List<Integer>tmp = new ArrayList<Integer>();
    public void backtracking(int[]visited,int m){
        if(tmp.size() == m){
            combine.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0;i < m;i++){
            if(visited[i] == 0){
                tmp.add(i);
                visited[i] = 1;
                backtracking(visited, m);
                tmp.remove(tmp.size() - 1);
                visited[i] = 0;
            }
        }
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length,n = students[0].length;
        int[][] point = new int[m][m];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < m;j++){
                int temp = 0;
                for(int k = 0;k < n;k++){
                    if(students[i][k] == mentors[j][k]){
                        temp++;
                    }    
                }
                point[i][j] = temp;
            }
        }
        int[] visited = new int[m];
        backtracking(visited, m);
        int ans = 0;
        for(int i = 0;i < combine.size();i++){
            int temp = 0;
            for(int j = 0; j < m;j++){
                temp += point[j][combine.get(i).get(j)];
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
// @lc code=end

