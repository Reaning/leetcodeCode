/*
 * @lc app=leetcode.cn id=79 lang=cpp
 *
 * [79] 单词搜索
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int direction[4][2] = {{1,0},{0,1},{-1,0},{0,-1}};
    vector<pair<int,int>>start;
    int** visited;
    bool dfs(string word,int cur,int x,int y,vector<vector<char>>board){
        if (cur == word.size())return true;
        int m = board.size(),n = board[0].size();
        for(int i = 0;i < 4;i++){
            int xi = x + direction[i][0];
            int yi = y + direction[i][1];
            if(xi >= 0 && yi >= 0 && xi < m && yi < n && board[xi][yi] == word[cur] && visited[xi][yi] == 0){
                visited[xi][yi] = 1;
                if(dfs(word,cur + 1, xi, yi, board)){
                    return true;
                }
                visited[xi][yi] = 0;
            }
        }
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(),n = board[0].size();
        visited = new int* [m];
        for(int i = 0; i< m;i++){
            visited[i] = new int [n];
            for(int j = 0; j< n;j++){
                visited[i][j] = 0;
            }
        }
        for(int i = 0; i < m;i++){
            for(int j = 0 ;j < n;j++){
                if(board[i][j] == word[0]){
                    visited[i][j] = 1;
                    if(word.length() == 1)return true;
                    if(dfs(word,1,i,j,board)) return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }
};
// @lc code=end

