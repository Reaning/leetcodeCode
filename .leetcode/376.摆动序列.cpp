/*
 * @lc app=leetcode.cn id=376 lang=cpp
 *
 * [376] 摆动序列
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        if(nums.size()<2)return nums.size();
        int pre=0,cur=0,res=2;
        for(int i = 1;i < nums.size();i++){
            cur = nums[i] - nums[i-1];
            if(cur*pre<0)res++;
            if(!cur)cur = pre;
            pre = cur;
        }
        if(cur==pre&&pre==0&&res==2&&nums[0]==nums[nums.size()-1])return 1;
        return res;
    }
};
// @lc code=end

