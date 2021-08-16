/*
 * @lc app=leetcode.cn id=977 lang=cpp
 *
 * [977] 有序数组的平方
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int length = nums.size();
        int right = 0;
        for(right;right < length;right++){
            if(nums[right]>=0)break;
        }
        vector<int>ans;
        int mid = right;
        int left = mid - 1;
        for(int i = 0; i < length; i++){
            if(left<0){
                ans.push_back(nums[right]*nums[right]);
                right++;
            }
            else if(right >= length){
                ans.push_back(nums[left]*nums[left]);
                left--;
            }
            else{
                if(pow(nums[left],2)<pow(nums[right],2)){
                    ans.push_back(pow(nums[left--],2));
                }else{
                    ans.push_back(pow(nums[right++],2));
                }
            }
        }
        return ans;
    }
};
// @lc code=end

