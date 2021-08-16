/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子序和
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int cur = nums[0],length = nums.size(), ans = cur;
        for(int i = 1;i<length;i++){
            cur += nums[i];
            cur = nums[i]>cur?nums[i]:cur;
            ans = max(ans,cur);
        }
        return ans;
    }
};
// @lc code=end

