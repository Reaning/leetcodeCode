/*
 * @lc app=leetcode.cn id=278 lang=cpp
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int firstBadVersion(int n) {
        int left = 1,right = n;
        while(left<right){
            int mid = (right - left)/2+left;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
};
// @lc code=end

