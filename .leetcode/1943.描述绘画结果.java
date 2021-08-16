import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1943 lang=java
 *
 * [1943] 描述绘画结果
 */

// @lc code=start
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int n = segments.length;
        Arrays.sort(segments,(a,b)->a[0] - b[0]);
    }
}
// @lc code=end

