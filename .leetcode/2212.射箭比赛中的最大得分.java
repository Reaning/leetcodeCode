import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2212 lang=java
 *
 * [2212] 射箭比赛中的最大得分
 */

// @lc code=start
class Solution {

    public int max = Integer.MIN_VALUE;
    int[] ans = new int[12];

    public void dfs(int[] b,int[] a,int remain,int i,int point){
        if(remain < 0){
            return;
        }
        if(i == 12){
            max = Math.max(point, max);
            if(point == max){
                for(int j = 0;j < 12;j++){
                    ans[j] = b[j];
                }
                ans[11] += remain;
            }
            return;
        }
        dfs(b, a, remain, i + 1, point);
        b[i] = a[i] + 1;
        dfs(b, a, remain - a[i] - 1, i + 1, point + i);
        b[i] = 0;
    }
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[]b = new int[12];
        dfs(b, aliceArrows, numArrows, 1,0);
        return ans;
    }
}
// @lc code=end

