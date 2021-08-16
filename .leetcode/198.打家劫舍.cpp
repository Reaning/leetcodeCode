/*
 * @lc app=leetcode.cn id=198 lang=cpp
 *
 * [198] 打家劫舍
 */
// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==1)return nums[0];
        if(nums.size()==2)return max(nums[0],nums[1]);
        if(nums.size()==3)return max(nums[0]+nums[2],nums[1]);
        vector<int>dp(nums.size(),0);
        dp[0] = nums[0];
        dp[1] = max(nums[0],nums[1]);
        dp[2] = max(nums[0]+nums[2],nums[1]);
        for(int i = 3;i<nums.size();i++){
            dp[i]=max(dp[i-3]+nums[i],dp[i-2]+nums[i]);
        }
        for(int i = 0;i<nums.size();i++){
            cout<<dp[i]<<" ";
        }
        cout<<endl;
        return max(dp[nums.size()-1],dp[nums.size()-2]);
    }
};
// @lc code=end

