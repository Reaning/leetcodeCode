import java.util.Random;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    public int[] cur;
    public int[] org;
    Random rand = new Random();
    public int randnum(int begin,int end){
        return rand.nextInt(end - begin) + begin;
    }
    public void swap(int left,int right){
        int temp = cur[left];
        cur[left] = cur[right];
        cur[right] = temp;
    }
    public Solution(int[] nums) {
        cur = nums;
        org = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        cur = org.clone();
        return org;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = cur.length;
        for(int i = 0; i < n;i++){
            swap(i,randnum(i, n));
        }
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

