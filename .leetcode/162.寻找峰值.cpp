/*
 * @lc app=leetcode.cn id=162 lang=cpp
 *
 * [162] 寻找峰值
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        if(n == 1)return 0;
        int left = 0,right = n - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if((mid == 0||nums[mid] > nums[mid - 1]) && (mid == n - 1||nums[mid] > nums[mid + 1]))return mid;
            else if(nums[mid] > nums[mid + 1])right = mid;
            else left = mid + 1;
        }
        return left;
    }
};
// @lc code=end

