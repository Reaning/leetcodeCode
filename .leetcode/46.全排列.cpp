/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>>ans;
    vector<int>temp;
    void backtracking(vector<int>&nums,vector<bool>&used){
        if(temp.size()==nums.size()){
            ans.push_back(temp);
            return;
        }
        for(int i = 0;i<nums.size();i++){
            if(used[nums[i]+10]){
                temp.push_back(nums[i]);
                used[nums[i]+10] = false;
                backtracking(nums,used);
                used[nums[i]+10] = true;
                temp.pop_back();
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<bool>used(21,true);
        backtracking(nums,used);
        return ans;
    }
};
// @lc code=end

