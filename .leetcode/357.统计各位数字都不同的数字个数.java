/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 统计各位数字都不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)return 1;
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n;i++){
            dp[i] = dp[i - 1];
        }
    }
}
// @lc code=end

