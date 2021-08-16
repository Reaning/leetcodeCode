/*
 * @lc app=leetcode.cn id=47 lang=cpp
 *
 * [47] 全排列 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>>ans;
    vector<int>temp;
    void backtracking(vector<int>&nums,vector<int>&n,vector<int>freq){
       if(temp.size() == nums.size()){
           ans.push_back(temp);
           return;
       }
       for(auto i : n){
           if(freq[i + 10]){
               freq[i + 10]--;
               temp.push_back(i);
               backtracking(nums,n,freq);
               temp.pop_back();
               freq[i + 10]++;
           }
       }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<int>freq(21,0);
        vector<int>n;
        for(auto i : nums){
            if(freq[i + 10] == 0)n.push_back(i);
            freq[i + 10]++;
        }
        backtracking(nums,n,freq);
        return ans;
    }
};
// @lc code=end

