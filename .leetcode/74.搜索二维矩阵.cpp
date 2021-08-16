/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int x = matrix.size(),y = matrix[0].size();
        int xi = x - 1,yi = 0;
        while(xi >= 0 && yi >= 0 && xi < x && yi < y){
            if(matrix[xi][yi] == target)return true;
            else if(matrix[xi][yi] > target)xi--;
            else yi++;
        }
        return false;
    }
};
// @lc code=end

