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
        LinkedList<Integer>q = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        Deque<Integer> qq = new LinkedList<>();
        Queue<Integer>qqq = new LinkedList<>();
        q.add(e)
        qq.add(e)
        qqq.add(e)
        qqq.peek();
        int j = 0;
        while(k-- > 0){
            if(q.isEmpty())q.add(nums[j++]);
            else{
                while(!q.isEmpty() && q.getLast() < nums[j])q.removeLast();
                q.add(nums[j++]);
            }
        }
        ans.add(q.peek());
        int left = 0;
        for(int i = j;i < n;i++){
            if(nums[left++] == q.peek()){
                q.pop();
            }
            while(!q.isEmpty() && q.getLast() < nums[i]){
                q.removeLast();
            }
            q.add(nums[i]);
            ans.add(q.peek());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

