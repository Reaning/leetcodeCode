/*
 * @lc app=leetcode.cn id=797 lang=cpp
 *
 * [797] 所有可能的路径
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>>ans;
    vector<int>temp;
    void backtracking(int index,vector<int>visited,vector<vector<int>>& graph){
        if(index == graph.size() - 1){
            ans.push_back(temp);
            return;
        }
        if(graph[index].size() == 0){
            return;
        }
        int n = graph[index].size();
        for(int i = 0; i < n;i++){
            if(visited[graph[index][i]] == 0){
                visited[graph[index][i]] = 1;
                temp.push_back(graph[index][i]);
                backtracking(graph[index][i],visited,graph);
                temp.pop_back();
                visited[graph[index][i]] = 0;
            }
        }
    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int>visited(n,0);
        visited[0] = 1;
        temp.push_back(0);
        backtracking(0,visited,graph);
        return ans;
    }
};
// @lc code=end

