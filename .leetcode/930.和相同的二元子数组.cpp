/*
 * @lc app=leetcode.cn id=930 lang=cpp
 *
 * [930] 和相同的二元子数组
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        int left = 0,right = 0,ans = 0;
        int left2 = 0;
        int n = nums.size();
        int sum1 = 0,sum2 = 0;
        while(right < n){
            sum1 += nums[right];
            while (left <= right&&sum1 > goal)
            {
                sum1 -= nums[left];
                left++;
            }
            sum2 += nums[right];
            while(left2 <= right && sum2 >= goal){
                sum2 -= nums[left2];
                left2++;
            }
            ans += left2 - left;
            right++;
        } 
        return ans;
    }
};
// @lc code=end

