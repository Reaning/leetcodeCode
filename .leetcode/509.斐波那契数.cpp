/*
 * @lc app=leetcode.cn id=509 lang=cpp
 *
 * [509] 斐波那契数
 */

// @lc code=start

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int fib(int n) {
        int nums[2];
        nums[0] = 0;
        nums[1] = 1;
        if(n<=1)return n;
        for(int i = 2;i<=n;i++){
            int sum = nums[0] + nums[1];
            nums[0] = nums[1];
            nums[1] = sum;
        }
        return nums[1];
    }
};
// @lc code=end

