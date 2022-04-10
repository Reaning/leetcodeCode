import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] nums = Arrays.stream(strs).map((str)->{
            int[] result = new int[2];
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) == '0')result[0]++;
                else if(str.charAt(i) == '1')result[1]++;
            }
            return result;
        }).toArray(size->new int[size][2]);
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = m;j >= nums[i][0];j--){
                for(int k = n;k >= nums[i][1];k--){
                    if(j - nums[i][0] >= 0 && k - nums[i][1] >= 0){
                        dp[j][k] = Math.max(dp[j - nums[i][0]][k - nums[i][1]] + 1,dp[j][k]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

