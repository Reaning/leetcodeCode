/*
 * @lc app=leetcode.cn id=1838 lang=cpp
 *
 * [1838] 最高频元素的频数
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        if(!nums.size())return 0;
        sort(nums.begin(),nums.end());
        int t = 0;
        int temp = nums[0],index = 0,n = nums.size();
        while(index < n && nums[index] == temp){
            index++;
        }
        int right =  nums[index];
        
    }
};
// @lc code=end

