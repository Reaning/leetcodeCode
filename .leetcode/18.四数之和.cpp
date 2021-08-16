/*
 * @lc app=leetcode.cn id=18 lang=cpp
 *
 * [18] 四数之和
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n = nums.size();
        vector<vector<int>>ans;
        sort(nums.begin(),nums.end());
        for(int i = 0;i < n - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)continue; 
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)break;
            for(int j = i + 1;j < n - 2;j++){
                if(nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target)continue;
                if(nums[i] + nums[j] + nums[j + 2] + nums[j + 1] > target)break;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1,right = n - 1;
                while(left < right){
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        ans.push_back({nums[i],nums[j],nums[left],nums[right]});
                        int left1 = left;
                        while(left < n && nums[left1] == nums[left]){
                            left++;
                        }
                        int right1 = right;
                        while(right >= 0 && nums[right] == nums[right1]){
                            right--;
                        }
                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
};
// @lc code=end

