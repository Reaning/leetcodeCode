/*
 * @lc app=leetcode.cn id=526 lang=java
 *
 * [526] 优美的排列
 */

// @lc code=start
class Solution {
    public int countArrangement(int n) {
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for(int mask = 1; mask < 1 << n;mask++){
            int num = Integer.bitCount(mask);//加入的位置
            for(int i = 0; i < n;i++){//i + 1为加入位置的值
                if((((1<<i) & mask) != 0) && (num % (i + 1) == 0 || (i + 1) % num == 0)){
                    dp[mask] += dp[mask ^ (1 << i)];
                }
            }
        }
        return dp[(1<<n) - 1];
    }
}
// @lc code=end

