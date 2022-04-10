import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int m = wordDict.size();
        dp[0] = 1;
        for(int i = 1;i <= n;i++){
            for(int j = 0;j < m;j++){
                int length = wordDict.get(j).length();
                if(i - length >= 0 && dp[i - length] != 0){
                    if(s.substring(i - length, i).equals(wordDict.get(j)) && dp[i] != 1){
                        dp[i] = dp[i - length];
                    }
                }
            }
        }
        return dp[n] == 1;
    }
}
// @lc code=end

