/*
 * @lc app=leetcode.cn id=207 lang=cpp
 *
 * [207] 课程表
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>>edges;
    vector<int>visited;
    bool ok = true;
    void dfs(int begin){
        visited[begin] = 1;
        if(edges[begin].size() == 0) {
            visited[begin] = 2;
            return;
        }
        for(auto i : edges[begin]){
            if(visited[i] == 0){
                dfs(i);
                if(!ok){
                    return;
                }
            }
            else if(visited[i] == 1){
                ok = false;
                return;
            }
        }
        visited[begin] = 2;
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        edges.resize(numCourses);
        visited.resize(numCourses);
        for(int i = 0;i < prerequisites.size();i++){
            edges[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        for(int i = 0;i < numCourses;i++){
            if(!visited[i]){
                dfs(i);
                if(!ok)break;
            }
        }
        return ok;
    }
};
// @lc code=end

