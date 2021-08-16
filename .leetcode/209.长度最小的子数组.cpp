/*
 * @lc app=leetcode.cn id=209 lang=cpp
 *
 * [209] 长度最小的子数组
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = -1,right = 0;
        int ans = INT_MAX;
        int tmp = 0;
        int all = 0;
        while(right < nums.size()){
            all += nums[right];
            tmp += nums[right];
            if(tmp >= target){
                while(left < right && tmp - nums[left + 1] >= target){
                    left++;
                    tmp -= nums[left];
                }
                ans = min(ans,right - left);
            }
            right++;
        }
        if(all < target)return 0;
        return ans;
    }
};
// @lc code=end

