/*
 * @lc app=leetcode.cn id=542 lang=cpp
 *
 * [542] 01 矩阵
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int x = mat.size(), y = mat[0].size();
        queue<pair<int,int>>q;
        vector<vector<int>>visited(x,vector<int>(y));
        vector<vector<int>>ans(x,vector<int>(y, 0));
        for(int i = 0; i < x;i++){
            for(int j = 0; j < y;j++){
                if(mat[i][j] == 0){
                    q.push(make_pair(i,j));
                    visited[i][j] = 1;
                }
            }
        }
        // int i,j;
        while (q.size()) {
            auto [i, j] = q.front();
            q.pop();
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < x && nj >= 0 && nj < y && !visited[ni][nj]) {
                    ans[ni][nj] = ans[i][j] + 1;
                    q.emplace(ni, nj);
                    visited[ni][nj] = 1;
                }
            }
        }
        return ans;
    }
};
// @lc code=end

