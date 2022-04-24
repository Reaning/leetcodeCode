/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public void maxHeap(int[] nums,int i,int n){
        for(;(i << 1) + 1 < n;){
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if(lson < n && nums[lson] > nums[i]){
                large = lson;
            }else{
                large = i;
            }
            if(rson < n && nums[rson] > nums[large]){
                large = rson;
            }
            if(large != i){
                swap(nums, i, large);
                i = large;
            }else{
                break;
            }
        }
    }
    public void buildMaxheap(int[] nums,int n){
        for(int i = (n - 1) / 2;i >= 0;--i){
            maxHeap(nums, i, n);
        }
    }
    public void heapSort(int[] nums){
        int n = nums.length;
        buildMaxheap(nums, n);
        for(int i = n - 1;i >= 1;i--){
            swap(nums, 0, i);
            n -= 1;
            maxHeap(nums, 0, n);
        }
    }
    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}
// @lc code=end

