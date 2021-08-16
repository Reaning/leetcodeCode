/*
 * @lc app=leetcode.cn id=69 lang=cpp
 *
 * [69] x 的平方根
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int mySqrt(int x) {
        if(x < 2)return x;
        long long left = 1,right = x;
        while(left <= right){
            long long mid = left + (right - left)/2;
            if(mid * mid == (long long)x)return mid;
            else if(mid * mid > (long long)x)right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
};
// @lc code=end

