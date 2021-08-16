/*
 * @lc app=leetcode.cn id=647 lang=cpp
 *
 * [647] 回文子串
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countSubstrings(string s) {
        int length = s.length();
        int ans = 0;
        vector<vector<bool>>dp(length,vector<bool>(length,false));
        for(int i = length - 1 ; i >= 0;i--){
            for(int j = i;j<length;j++){
                if(s[i]==s[j]){
                    if(j - i<=1)
                        dp[i][j]=true;
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                    ans = dp[i][j]?ans+1:ans;
                }
            }
        }
        return ans;
    }
};
// @lc code=end

