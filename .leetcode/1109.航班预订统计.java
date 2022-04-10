/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]ans = new int[n];
        for(int i = 0;i < bookings.length;i++){
            ans[bookings[i][0] - 1] += bookings[i][2];
            if(n >bookings[i][1]){
                ans[bookings[i][1]] -=bookings[i][2];
            }
        }
        for(int i = 1;i < n;i++){
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
// @lc code=end

