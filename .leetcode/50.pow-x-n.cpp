/*
 * @lc app=leetcode.cn id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    double Pow(double x, long long n){
        if(x == 1.0)return 1;
        if(n == 0)return 1;
        int a = n % 2;
        double temp = x;
        double ans = (a == 0?1:temp);
        n = n / 2; 
        while(n){
            a = n % 2;
            temp = temp * temp;
            ans = (a == 0?ans:temp * ans);
            n = n / 2;
        }
        return ans;
    }
    double myPow(double x, int n) {
        if(n == 0)return 1;
        long long N = n;
        return n>0?Pow(x,N):1 / Pow(x, -N);
    }
};
// @lc code=end

