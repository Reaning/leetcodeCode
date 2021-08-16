/*
 * @lc app=leetcode.cn id=645 lang=cpp
 *
 * [645] 错误的集合
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int>ans;
        vector<int>temp(nums.size(),0);
        for (int i = 0; i < nums.size(); i++)
        {
           temp[nums[i]-1]++;
           if(temp[nums[i]-1]==2){
               ans.push_back(nums[i]);
           }
        }
        for(int i = 0;i<nums.size();i++){
            if(!temp[i]){
                ans.push_back(i+1);
                break;
            }
        }
        
        return ans;   
    }
};
// @lc code=end

