import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组是否存在循环
 */

// // @lc code=start
// class Solution {
//     public int[] cur;
//     public int n;
//     public int next(int ptr){
//         ptr = (ptr + cur[ptr] + 1000*n) % n;
//         return ptr;
//     }
//     public boolean circularArrayLoop(int[] nums) {
//         if(nums.length == 1)return false;
//         cur = nums;
//         n = nums.length;
//         for(int i = 0;i < n;i++){
            
//             System.out.println("i" + i);
//             int slow = i,fast = next(slow);
//             if(slow == fast)continue;
//             while(slow != fast){
//                 slow = next(slow);
//                 fast = next(next(fast));
//             }
//             fast = next(slow);
//             // System.out.println(slow + " " + fast);
//             if(fast == slow )continue;
//             if(nums[fast] * nums[slow] < 0)continue;
//             int flag = 1;
//             while(fast != slow){
//                 fast = next(fast);
//                 // System.out.println(fast);
//                 if(nums[fast] * nums[slow] < 0){
//                     flag = 0;
//                     break;
//                 }
//             }
//             if(flag != 0)return true;
//         }
//         return false;
//     }
// }
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        List<Integer> d = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(d.isEmpty() || d.get(d.size() - 1) <= obstacles[i]){
                d.add(obstacles[i]);
                ans.add(d.size());
            }
            else{
                int left = 0,right = d.size() - 1;
                int mid = ((right - left) >> 1) + left;
                while(left < right){
                    if(d.get(mid) < obstacles[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                d.set(left, obstacles[i]);
                ans.add(left + 1);
            }
        }
        int m = ans.size();
        int[] a = new int[m];
        for(int i = 0;i < m;i++){
            a[i] = ans.get(i);
        }
        return a;
    }
}
// @lc code=end

