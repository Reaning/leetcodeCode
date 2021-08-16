/*
 * @lc app=leetcode.cn id=733 lang=cpp
 *
 * [733] 图像渲染
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int temp = image[sr][sc];
        stack<pair<int,int>>st;
        int rn = image.size(),cn = image[0].size();
        st.push(make_pair(sr,sc));
        while(st.size()){
            auto top = st.top();
            st.pop();
            image[top.first][top.second] = -1;
            int r = top.first, c = top.second;
            if(r > 0 && image[r - 1][c] == temp)st.push(make_pair(r - 1,c));
            if(r < rn - 1 && image[r + 1][c] == temp)st.push(make_pair(r + 1,c));
            if(c > 0 && image[r][c - 1] == temp)st.push(make_pair(r,c - 1));
            if(r < cn - 1 && image[r][c + 1] == temp)st.push(make_pair(r,c + 1));
        }
        for(int i = 0;i < rn;i++){
            for(int j = 0;j < cn;j++){
                if(image[i][j] == -1)image[i][j] = newColor;
            }
        }
        return image;
    }
};
// @lc code=end

