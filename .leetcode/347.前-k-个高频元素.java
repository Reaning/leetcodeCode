import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer>mp = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                return a[1] - b[1];
            }
        });
        for(int i = 0;i < n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            int[] temp = new int[]{entry.getKey(),entry.getValue()};
            heap.add(temp);
            if(heap.size() == k + 1){
                heap.poll();
            }
        }
        int[]ans = new int[k];
        System.out.println(heap.size());
        while(--k >= 0){
            ans[k] = heap.poll()[0];
        }
        return ans;
    }
}
// @lc code=end

