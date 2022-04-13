import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> list = new LinkedList<>();
        for(int i = 0;i < k;i++){
            while(!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                list.pollLast();
            }
            list.addLast(i);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[list.getFirst()]);
        for(int i = k;i < n;i++){
            if(list.getFirst() <= i - k){
                list.removeFirst();
            }
            while(!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                list.pollLast();
            }
            list.addLast(i);
            ans.add(nums[list.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

