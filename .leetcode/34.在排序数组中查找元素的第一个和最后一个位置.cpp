/*
 * @lc app=leetcode.cn id=34 lang=cpp
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int left = lower_bound(nums.begin(),nums.end(),target) - nums.begin();
        if(nums[left] != target)return {-1,-1};
        int right = upper_bound(nums.begin(),nums.end(),target) - nums.begin();
        return {left,right};
    }
};
// @lc code=end

