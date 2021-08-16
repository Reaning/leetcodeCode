/*
 * @lc app=leetcode.cn id=746 lang=cpp
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int>dp(cost.size());
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i<cost.size();i++){
            dp[i] = min(dp[i - 1],dp[i - 2]) + cost[i];
        }
        return min(dp[dp.size() - 1],dp[dp.size() - 2]);
    }
};
// @lc code=end

