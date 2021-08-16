/*
 * @lc app=leetcode.cn id=1137 lang=cpp
 *
 * [1137] 第 N 个泰波那契数
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int tribonacci(int n) {
        if(n<=1)return n;
        if(n == 2)return 1;
        int a = 0,b = 1,c = 1;
        for(int i = 3;i <= n;i++){
            int temp = c;
            c = a + b + c;
            a = b;
            b = temp;
        }
        return c;
    }
};
// @lc code=end

