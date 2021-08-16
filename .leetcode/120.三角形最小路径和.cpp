/*
 * @lc app=leetcode.cn id=120 lang=cpp
 *
 * [120] 三角形最小路径和
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size();
        int n = triangle[m - 1].size();
        if(m == 1&& n == 1)return triangle[0][0];
        vector<vector<int>>dp(m,vector<int>(n,INT_MAX));
        dp[0][0] = triangle[0][0];
        int ans = INT_MAX;
        for(int i = 1;i < m;i++){
            for(int j = 0;j <= i;j++){
                if(j + 1 <= i && j >= 1)
                    dp[i][j] = min(triangle[i][j] + dp[i - 1][j],dp[i - 1][j - 1] + triangle[i][j]);
                else if(j == 0)dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if(j == i)dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                if(i == m - 1)ans = min(ans,dp[i][j]);
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                cout<<dp[i][j]<<" ";
            }
            cout<<endl;
        }
        return ans;
    }
};
// @lc code=end

