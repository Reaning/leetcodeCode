/*
 * @lc app=leetcode.cn id=994 lang=cpp
 *
 * [994] 腐烂的橘子
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int orangesRotting(vector<vector<int>>& grid) {
        int x = grid.size(),y = grid[0].size();
        int fresh = 0,f = 0,ans = 0;
        vector<vector<int>>visited(x,vector<int>(y,0));
        queue<pair<int,int>>q;
        for(int i = 0;i < x;i++)
            for(int j = 0;j < y;j++){
                if(grid[i][j] == 1)fresh++;
                if(grid[i][j] == 2){
                    f++;
                    visited[i][j] = 1;
                    q.emplace(i,j);
                }
            }
        while(q.size()){
            int xi = q.front().first;
            int yi = q.front().second;
            q.pop();
            for(int i = 0;i < 4;i++){
                int xn = xi + dirs[i][0];
                int yn = yi + dirs[i][1];
                if(xn >= 0 && xn < x && yn < y && yn >= 0 && visited[xn][yn] == 0 && grid[xn][yn] == 1){
                    visited[xn][yn] = 1;
                    grid[xn][yn] = grid[xi][yi] + 1;
                    ans = max(ans,grid[xn][yn] - 2);
                    q.emplace(xn,yn);
                    fresh--;
                }
            }
        }
        if(fresh > 0)return -1;
        return ans;
    }
};
// @lc code=end

