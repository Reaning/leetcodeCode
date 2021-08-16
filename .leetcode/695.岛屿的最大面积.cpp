/*
 * @lc app=leetcode.cn id=695 lang=cpp
 *
 * [695] 岛屿的最大面积
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int rn = grid.size(),cn = grid[0].size();
        stack<pair<int,int>>st;
        int ans = 0;
        for(int i = 0;i < rn; i++){
            for(int j = 0;j < cn;j++){
                if(grid[i][j] == 1){
                    st.push(make_pair(i,j));
                    int size = 0;
                    while(st.size()){
                        int r = st.top().first, c = st.top().second;
                        if(grid[r][c] == 0){
                            st.pop();
                            continue;
                        }
                        grid[r][c] = 0;
                        st.pop();
                        size++;
                        if(r > 0 && grid[r - 1][c] == 1)st.push(make_pair(r - 1,c));
                        if(r < rn - 1 && grid[r + 1][c] == 1)st.push(make_pair(r + 1,c));
                        if(c > 0 && grid[r][c - 1] == 1)st.push(make_pair(r,c - 1));
                        if(c < cn - 1 && grid[r][c + 1] == 1)st.push(make_pair(r,c + 1));
                    }
                    ans = max(ans,size);
                }
            }
        }
        return ans;
    }
};
// @lc code=end

