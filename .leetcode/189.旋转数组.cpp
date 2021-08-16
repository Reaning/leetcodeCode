/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    void reverse(vector<int>&nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    void rotate(vector<int>& nums, int k) {
        int length = nums.size();
        int t = k%length;
        if(t==0)return;
        reverse(nums,0,length-1);
        reverse(nums,0,t - 1);
        reverse(nums,t,length - 1);
    }
};
// @lc code=end

