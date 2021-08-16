import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1)return 1;
        PriorityQueue<Long> heap = new PriorityQueue<>(){{add(1L);}};
        HashSet<Long> s = new HashSet<>(){{add(1L);}};
        int m = primes.length;
        int t = 1;
        while(t < n){
            Long temp = heap.poll();
            for(int i = 0;i < m;i++){
                Long k = temp * primes[i];
                if(s.size() < 1000000  && s.contains(k) == false){
                    heap.add(k);
                    s.add(k);
                }
            }
            t++;
        }
        return heap.poll().intValue();
    }
}
// @lc code=end

