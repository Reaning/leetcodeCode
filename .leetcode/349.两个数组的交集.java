import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>s = new HashSet<>();
        Set<Integer>n = new HashSet<>();
        for (int num : nums1){
            n.add(num);
        }
        for (int num : nums2){
            if(n.contains(num)){
                s.add(num);
            }
        }
        int[] ans = new int[s.size()];
        int index = 0;
        for(int num : s){
            ans[index++] = num;
        }
        return ans;
    }
}
// @lc code=end

