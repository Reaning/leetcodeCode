import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
            heap.add(nums[i]);
        }
        while(k-- > 0){
            int temp = heap.poll();
            temp = -temp;
            heap.add(temp);
            sum += 2*temp;
        }
        return sum;
    }
}
// @lc code=end

