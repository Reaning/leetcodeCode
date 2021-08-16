/*
 * @lc app=leetcode.cn id=547 lang=cpp
 *
 * [547] 省份数量
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int cur = 1;
        int n = isConnected.size();
        vector<int>visited(n,0);
        for(int i = 0; i < n;i++){
            if(visited[i] == 0){
                queue<int>q;
                q.push(i);
                while (q.size())
                {
                    int tmp = q.front();
                    q.pop();
                    visited[tmp] = cur;
                    for(int j = 0; j < n;j++){
                        if(isConnected[tmp][j] == 1 && visited[j] == 0)q.push(j);
                    }
                }
                cur++;
            }
        }
        return cur-1;
    }
};
// @lc code=end

