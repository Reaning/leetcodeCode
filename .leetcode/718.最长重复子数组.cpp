/*
 * @lc app=leetcode.cn id=718 lang=cpp
 *
 * [718] 最长重复子数组
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findLength(vector<int>& A, vector<int>& B) {
        if(!A.size()||!B.size()) return 0;
        int ans = 0;
        int m = A.size(),n = B.size();
        vector<vector<int>> dp(m + 1,vector<int>(n + 1,0));
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(A[i-1]==B[j-1])dp[i][j]=dp[i-1][j-1]+1;
                ans = max(dp[i][j],ans);
            }
        }
        return ans;
    }
};
// @lc code=end

