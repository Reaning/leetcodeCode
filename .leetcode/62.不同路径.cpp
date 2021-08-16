/*
 * @lc app=leetcode.cn id=62 lang=cpp
 *
 * [62] 不同路径
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m==1||n==1)return 1;
        int **dp = new int*[m];
        for(int i = 0;i<m;i++) dp[i] = new int[n];
        dp[0][1] = 1;
        dp[1][0] = 1;
        for(int i = 0;i <m;i++){
            for(int j = 0;j<n;j++){
                if((i!=0||j!=0)&&(i!=0||j!=1)&&(i!=1||j!=0)){
                    if(i==0&&j!=0)dp[i][j] = dp[i][j - 1];
                    else if(i!=0&&j==0)dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i][j - 1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
};
// @lc code=end

