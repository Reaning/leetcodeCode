import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> s = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        s.add(1L);
        heap.add(1L);
        int[]factor = {2,3,5};
        long temp = 1L;
        for(int i = 1; i <= n;i++){
            temp = heap.poll();
            for(int j = 0;j < 3;j++){
                if(s.add(temp * factor[j])){
                    heap.add(temp * factor[j]);
                }
            }
        }
        return (int)temp;
    }
}
// @lc code=end

