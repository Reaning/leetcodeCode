import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        Deque<int[]>stk = new LinkedList<>();
        for(int[] interval:intervals){
            stk.push(interval);
        }
        List<int[]>ans = new ArrayList<>();
        while(!stk.isEmpty()){
            int[] left = stk.poll();
            if(stk.isEmpty()){
                ans.add(0,left);
            }else{
                int[] right = stk.poll();
                if(left[0] <= right[1]){
                    int[] temp = new int[]{right[0],Math.max(left[1], right[1])};
                    ans.add(0,temp);
                }else{
                    ans.add(0,left);
                    stk.push(right);
                }
            }
        }
        return ans.toArray(new int[0][2]);
    }
}
// @lc code=end

