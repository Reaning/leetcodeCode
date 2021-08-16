import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1942 lang=java
 *
 * [1942] 最小未被占据椅子的编号
 */

// @lc code=start
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Integer>heap = new PriorityQueue<Integer>();
        Map<Integer,Integer>mp = new HashMap<>();
        int[][] arrival = new int[n][2];
        int[][] leaving = new int[n][2];
        for(int i = 0;i < n;i++){
            arrival[i][0] = times[i][0];
            arrival[i][1] = i;
            leaving[i][0] = times[i][1];
            leaving[i][1] = i;
        }
        Arrays.sort(arrival,(a,b)->a[0] - b[0]);
        Arrays.sort(leaving,(a,b)->a[0] - b[0]);
        for(int i = 0;i < n;i++){
            heap.offer(i);
        }
        int index = 0;
        for(int[]a : arrival){
            while(index < n && a[0] >= leaving[index][0]){
                heap.offer(mp.get(leaving[index][1]));
                index++;
            }
            int temp = heap.poll();
            mp.put(a[1], temp);
            if(a[1] == targetFriend)return temp;
        }
        return 0;
    }
}
// @lc code=end

