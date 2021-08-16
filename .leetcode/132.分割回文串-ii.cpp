/*
 * @lc app=leetcode.cn id=132 lang=cpp
 *
 * [132] 分割回文串 II
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<bool>>issame(string s){
        int length = s.length();
        vector<vector<bool>>dp(length,vector<bool>(length,false));
        for(int i = length;i>=0;i--){
            for(int j = i;j<length;j++){
                if(s[i]==s[j]){
                    if(j-i<=1)dp[i][j]=true;
                    else dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        return dp;
    }
    int minCut(string s) {
        vector<vector<bool>>ss = issame(s);
        int length = s.length();
        vector<int>dp(length,INT_MAX);
        dp[0]=0;
        for(int i = 1; i<length;i++){
            if(!ss[0][i]){
                for(int j = 0;j<i;j++){
                    if(ss[j+1][i])
                    dp[i] = min(dp[i],dp[j]+1); 
                }
            }else{
                dp[i]=0;
            }
        }
        return dp[length-1];
    }
};
// @lc code=end

