/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>>dp(word2.size()+1,vector<int>(word1.size()+1,0));
        for(int i = 1;i<=word2.size();i++)dp[i][0]=dp[i-1][0]+1;
        for(int i = 1;i<=word1.size();i++)dp[0][i]=dp[0][i-1]+1;
        for(int i = 1;i<=word2.size();i++){
            for(int j = 1;j<=word1.size();j++){
                if(word2[i-1]==word1[j-1])dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=min(dp[i-1][j]+1,min(dp[i-1][j-1]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[word2.size()][word1.size()];
    }
};
// @lc code=end

