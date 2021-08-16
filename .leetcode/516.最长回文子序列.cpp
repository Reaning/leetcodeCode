/*
 * @lc app=leetcode.cn id=516 lang=cpp
 *
 * [516] 最长回文子序列
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int length = s.length();
        vector<vector<int>>dp(length,vector<int>(length,0));
        for(int i=0;i<length;i++)dp[i][i]=1;
        for(int i = 1;i<length;i++){
            for(int j = 0;j+i<length;j++){
                dp[j][i+j];
                if(s[j]==s[i+j]){
                    dp[j][i+j]=dp[j+1][i+j-1]+2;
                }else{
                    dp[j][i+j]=max(dp[j+1][i+j],dp[j][i+j-1]);
                }
            }
        }
        return dp[0][length-1];
    }
};
// @lc code=end

