/*
 * @lc app=leetcode.cn id=713 lang=cpp
 *
 * [713] 乘积小于K的子数组
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int len = nums.size();
        int dp_1 = 1, dp_2 = 0, ans = 0, left = 0, right = 0;
        while(right < len) {
            dp_1 *= nums[right++];
            dp_2 += 1; 
            while (left < right && dp_1 >= k) {
                dp_1 /= nums[left++];
                dp_2 -= 1;
            }
            ans += dp_2;
        }
        return ans;
    }
};
// @lc code=end

