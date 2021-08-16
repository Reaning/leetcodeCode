/*
 * @lc app=leetcode.cn id=240 lang=cpp
 *
 * [240] 搜索二维矩阵 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n1 = matrix.size(),n2 = matrix[0].size();
        int left1 = 0,right1 = n1 - 1;
        int left2 = 0,right2 = n2 - 1;
        while(left1 <= right1){
            int mid1 = left1 + (right1 - left1)/2;
            if(target <= matrix[mid1][0]){
                right1 = mid1 - 1;
            }else{
                left1 = mid1 + 1;
            }
        }
        if(left1 < n1 && matrix[left1][0] == target) return true;
        for(int i = 0;i < left1; i++){
            left2 = 0,right2 = n2 - 1;
            while(left2 <= right2){
                int mid2 = left2 + (right2 - left2)/2;
                if(matrix[i][mid2] >= target)right2 = mid2 - 1;
                else left2 = mid2 + 1;
            }
            if(matrix[i][left2] == target) return true;
        }
        return false;
    }
};
// @lc code=end

