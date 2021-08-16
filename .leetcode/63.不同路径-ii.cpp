/*
 * @lc app=leetcode.cn id=63 lang=cpp
 *
 * [63] 不同路径 II
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        if(obstacleGrid[0][0])return 0;
        if(m==1||n==1){
            int flag = 1;
            for(int i = 0;i<m;i++)
                for(int j = 0;j<n;j++)
                    if(obstacleGrid[i][j])flag=0;
            return flag;
        }
        int **dp = new int*[m];
        for(int i = 0;i<m;i++) dp[i] = new int[n];
        dp[0][1] = obstacleGrid[0][1]?0:1;
        dp[1][0] = obstacleGrid[1][0]?0:1;
        for(int i = 0;i <m;i++){
            for(int j = 0;j<n;j++){
                if((i!=0||j!=0)&&(i!=0||j!=1)&&(i!=1||j!=0)){
                    if(obstacleGrid[i][j])dp[i][j]=0;
                    else if(i==0&&j!=0){
                        dp[i][j] = dp[i][j - 1];
                    }
                    else if(i!=0&&j==0){
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i][j - 1]+dp[i-1][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
};

// @lc code=end

