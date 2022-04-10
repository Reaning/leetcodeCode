import javax.swing.text.DefaultEditorKit.CopyAction;

/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int n = gas.length;
        int start = 0;
        for(int i = 0;i < n;i++){
            int temp = gas[i] - cost[i];
            cur += temp;
            total += temp;
            if(cur < 0){
                start = i + 1;
                cur = 0;
            }
        }
        if(total < 0)return -1;
        return start;
    }
}
// @lc code=end

