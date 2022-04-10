import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp =new boolean[n + 1][n + 1];
        int ans = n;
        for(int i = 0;i <= n;i++){
            for(int j = i;j >= 0;j--){
                dp[i][j] = true;
            }
        }
        for(int i = 1;i <= n;i++){
            for(int j = 1;i + j <= n;j++){
                if(s.charAt(j - 1) == s.charAt(i + j - 1)){
                    dp[j][i + j] = dp[j + 1][i + j - 1];
                    if(dp[j][i + j])ans++;
                }else{
                    dp[j][i + j] = false;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

