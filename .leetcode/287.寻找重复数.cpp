/*
 * @lc app=leetcode.cn id=287 lang=cpp
 *
 * [287] 寻找重复数
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int left = 0,right = 1;
        int n = nums.size();
        while(right < n && nums[left] != nums[right]){
            left++;
            right++;
        }
        return nums[left];
    }
};
// @lc code=end

