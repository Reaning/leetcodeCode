/*
 * @lc app=leetcode.cn id=51 lang=cpp
 *
 * [51] N 皇后
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<string>>ans;
    bool isAvailable(int n,int row,vector<string>&temp){

    }
    void backtrade(int n,int row,vector<string>&temp){
        if(row==n){
            ans.push_back(temp);
            return;
        }
        for(int i = 0;i<n;i++){
            if(true){
                backtrade(n,row+1,temp);
                temp[row][i]='.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        string a = "";
        for(int i = 0;i<n;i++)a = a+'.';
        vector<string>temp(n,a);
        backtrade(n,0,temp);
    }
};
// @lc code=end

