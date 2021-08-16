/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除有序数组中的重复项
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int left = 0,right = 0;
        int n = nums.size();
        while(right < n){
            if(right != 0&&nums[right] == nums[right - 1]){
                while(right < n&&nums[right]==nums[right - 1]){
                    right++;
                }
            }
            if(right == n)return left;
            nums[left] = nums[right];
            left++;
            right++;
        }
        return left;
    }
};
// @lc code=end

