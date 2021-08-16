/*
 * @lc app=leetcode.cn id=210 lang=cpp
 *
 * [210] 课程表 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int>visited;
    vector<vector<int>>edges;
    vector<int>ans;
    bool ok = true;
    void dfs(int cur){
        visited[cur] = 1;
        for(auto i : edges[cur]){
            if(visited[i] == 1){
                ok = false;
                return;
            }else if (visited[i] == 0){
                dfs(i);
            }
            if(!ok)return;
        }
        visited[cur] = 2;
        ans.push_back(cur);
    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        visited.resize(numCourses);
        edges.resize(numCourses);
        for(auto i : prerequisites){
           edges[i[0]].push_back(i[1]);
        } 
        for(int i = 0;i < numCourses; i++){
            if(!visited[i]){
                dfs(i);
            }
            if(!ok)return {};
        }
        return ans;
    }
};

// @lc code=end

