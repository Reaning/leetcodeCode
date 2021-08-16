import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0,right = n - 1;
        int ans = 0;
        while(left <= right){
            int mid = (left + right) >> 1;
            int temp = n - mid;
            if(temp >= citations[mid]){
                ans = Math.max(ans,citations[mid]);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

