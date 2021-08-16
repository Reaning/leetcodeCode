/*
 * @lc app=leetcode.cn id=39 lang=cpp
 *
 * [39] 组合总和
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>> ans;
    vector<int>temp;
    void traversal(vector<int>a,int begin,int target){
        if(begin==a.size())return;
        if(target == 0){
            ans.push_back(temp);
            return;
        }
        traversal(a,begin + 1,target);
        if(a[begin]>target)return;
        temp.push_back(a[begin]);
        traversal(a,begin,target - a[begin]);
        temp.pop_back();
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        traversal(candidates,0,target);
        return ans;        
    }
};
// @lc code=end

