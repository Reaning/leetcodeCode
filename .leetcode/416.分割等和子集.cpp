/*
 * @lc app=leetcode.cn id=416 lang=cpp
 *
 * [416] 分割等和子集
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    bool canPartition(vector<int>& nums) {
        int len = nums.size();
        int sum = 0;
        if(len%2)return false;
        for(int i = 0;i<len;i++)sum+=nums[i];
        int target = sum/2;

        if(sum%2)return false;
        vector<int>dp(20001,0);
        for(int i = 0;i<len;i++){
            for(int j = target;j>=nums[i];j--){
                dp[j] = max(dp[j-nums[i]]+nums[i],dp[j]);
            }
            for(int k = 0;k<target;k++){
                cout<<dp[k]<<" ";
            }
            cout<<endl;
        }
        if(dp[target]==target)return true;
        return false;
    }
};
// @lc code=end

