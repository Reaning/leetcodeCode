/*
 * @lc app=leetcode.cn id=413 lang=cpp
 *
 * [413] 等差数列划分
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int isOk(vector<int> nums,int left){
        if(left + 2 >= nums.size())return 2001;
        int cur = nums[left + 1] - nums[left];
        if(nums[left + 2] - nums[left + 1] == cur)return cur;
        return 2001;
    }
    int numberOfArithmeticSlices(vector<int>& nums) {
        if(nums.size() < 3)return 0;
        int left = 0,right = 2;
        int cur = 0;
        int n = nums.size();
        int ans = 0;
        while(right < n){
            if(right - left == 2){
                cur = isOk(nums,left);
                if(cur == 2001)left++;
                else ans++;
            }else{
                int temp = nums[right] - nums[right - 1];
                if(temp == cur){
                    ans += right - left - 1;
                }else{
                    left = right - 1;
                    right = left + 1;
                }
            }
            right++;
        }
        return ans;
    }
};
// @lc code=end

