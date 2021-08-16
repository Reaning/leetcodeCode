/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        vector<vector<int>>ans;
        for(int i = 0;i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if(nums[i] + nums[n - 2] + nums[n - 1] < 0)continue;
            int left = i + 1,right = n - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp == 0){
                    ans.push_back({nums[i],nums[left],nums[right]});
                    while(left > i + 1&& nums[left] == nums[left - 1])left++;
                    left++;
                    while(right < n&& nums[right] == nums[right + 1])right--;
                    right--;
                }
                else if(temp > 0)right--;
                else if(temp < 0)left++;
            }
        }
        return ans;
    }
};
// @lc code=end

