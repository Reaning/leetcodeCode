import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int quicksort(int[] nums,int start,int end,int k){
        int left = start,right = end - 1;
        int temp = nums[start];
        while(left < right){
            while(left < right && nums[right] <= nums[start])right--;
            while(left < right && nums[left] >= nums[start])left++;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        temp = nums[start];
        nums[start] = nums[left];
        nums[left] = temp;
        if(left == k - 1)return nums[left];
        if(left > k - 1)return quicksort(nums, start, left, k);
        return quicksort(nums, left + 1, end, k);
    }
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<>(){
        //     public int compare(Integer a, Integer b) {
        //         return b - a;
        //     }
        // }
        // );
        // for(int i = 0;i < nums.length;i++)heap.offer(nums[i]);  
        // for(int i = 0;i < k - 1;i++){
        //     heap.poll();
        // }
        return quicksort(nums, 0, nums.length, k);
    }
}
// @lc code=end

