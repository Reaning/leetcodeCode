/*
 * @lc app=leetcode.cn id=55 lang=cpp
 *
 * [55] 跳跃游戏
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int cover = 0;
        if(nums.size()==1)return true;
        for(int i=0;i<=cover;i++){
            cover = max(i+nums[i],cover);
            if(cover>=nums.size()-1)return true;
        }
        return false;
    }
};
// @lc code=end

