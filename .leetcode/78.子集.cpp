/*
 * @lc app=leetcode.cn id=78 lang=cpp
 *
 * [78] 子集
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>>ans;
    vector<int>temp;
    void backtracking(int index, vector<int>& nums){
        if(index >= nums.size()){
            ans.push_back(temp);
            return;
        }
        backtracking(index + 1,nums);
        temp.push_back(nums[index]);
        backtracking(index + 1,nums);
        temp.pop_back();
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        backtracking(0,nums);
        return ans;
    }
};
// @lc code=end

