/*
 * @lc app=leetcode.cn id=115 lang=cpp
 *
 * [115] 不同的子序列
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numDistinct(string s, string t) {
        int slength = s.length(),tlength = t.length();
        vector<vector<unsigned long long>>dp(slength+1,vector<unsigned long long>(tlength+1,0));
        for(int i = 0;i<=slength;i++)dp[i][0]=1;
        for(int i = 1;i<=slength;i++){
            for(int j = 1;j<=i&&j<=tlength;j++){
                if(s[i-1]==t[j-1]){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[slength][tlength];
    }
};
// @lc code=end

