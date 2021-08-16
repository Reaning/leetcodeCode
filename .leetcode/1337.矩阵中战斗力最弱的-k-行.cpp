/*
 * @lc app=leetcode.cn id=1337 lang=cpp
 *
 * [1337] 矩阵中战斗力最弱的 K 行
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        int m = mat.size(),n = mat[0].size();
        // vector<pair<int,int>>power;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>q;
        for(int i = 0; i < m;i++){
            int left = 0,right = n - 1;
            int pos = -1;
            while(left <= right){
                int mid = (right - left)/2 + left;
                if(mat[i][mid] == 1){
                    left = mid + 1;
                    pos = mid;
                }else{
                    right = mid - 1;
                }
            }
            q.emplace(pos + 1,i);
        }
        vector<int>ans;
        while(k--){
            ans.push_back(q.top().second);
            q.pop();
        }
        return ans;
    }
};
// @lc code=end

