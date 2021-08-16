/*
 * @lc app=leetcode.cn id=392 lang=cpp
 *
 * [392] 判断子序列
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        vector<vector<int>>dp(t.size()+1,vector<int>(s.size()+1,0));
        for(int i = 1;i<=t.size();i++){
            for(int j = 1;j<=s.size();j++){
                if(s[j-1]==t[i-1])dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[t.size()][s.size()]==s.size();
    }
};
// @lc code=end

