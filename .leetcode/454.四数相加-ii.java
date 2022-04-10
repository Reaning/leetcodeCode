import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer>mp1 = new HashMap<>();
        Map<Integer,Integer>mp2 = new HashMap<>();
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                mp1.put(nums1[i] + nums2[j], mp1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        for(int i = 0;i < nums3.length;i++){
            for(int j = 0;j < nums4.length;j++){
                mp2.put(nums3[i] + nums4[j], mp2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }
        Set<Integer> keys1 = mp1.keySet();
        int ans = 0;
        for(Integer i:keys1){
            int temp = mp1.get(i);
            if(mp2.containsKey(0 - i)){
                ans += temp * mp2.get(0 - i);
            }
        }
        return ans;
    }
}
// @lc code=end

