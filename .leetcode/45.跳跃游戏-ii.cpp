/*
 * @lc app=leetcode.cn id=45 lang=cpp
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int jump(vector<int>& nums) {
        vector<int>dp(nums.size(),1001);
        dp[0] = 0;
        for(int i = 1;i<nums.size();i++){
            for(int j = 0;j<i;j++){
                if(j+nums[j]>=i)dp[i] = min(dp[i],dp[j]+1);
            }
        }
        return dp[nums.size()-1];
    }
};
// @lc code=end

