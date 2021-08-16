/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int climbStairs(int n) {
        if(n<=2)return n;
        int nums[2];
        nums[0] = 1;
        nums[1] = 2;
        for(int i = 2;i < n; i++){
            int sum = nums[0]+nums[1];
            nums[0] = nums[1];
            nums[1] = sum;            
        }
        return nums[1];
    }
};
// @lc code=end

