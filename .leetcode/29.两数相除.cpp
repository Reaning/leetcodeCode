/*
 * @lc app=leetcode.cn id=29 lang=cpp
 *
 * [29] 两数相除
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int divide(int dividend, int divisor) {
        if(dividend == -2147483648 && divisor == -1)return 2147483647;
        if(dividend == 2147483647 && divisor == 1)return 2147483647;
        int flag = 1;
        if(dividend < 0 && divisor < 0){
            dividend = (dividend == INT_MIN?INT_MAX : -dividend);
            divisor =  (divisor == INT_MIN?INT_MAX : -divisor);
        }else if(dividend < 0 && divisor > 0){
            dividend = (dividend == INT_MIN?INT_MAX : -dividend);
            flag = 0;
        }else if(dividend > 0 && divisor < 0){
            divisor = (divisor == INT_MIN?INT_MAX : -divisor);
            flag = 0;
        }
        if(dividend < divisor)return 0;
        if(divisor + divisor > dividend || divisor == dividend)return flag?1:-1;
        int res = divisor;
        int pre = 1;
        for(long long i = 2; i < dividend; i = i + i){
            long long tmp = res + res;//本次，此时res为上一次
            if(tmp == dividend) return flag ? (i > INT_MAX?INT_MAX:i) : 0 - i;
            else if(tmp > dividend){
                long long temp = pre + divide((dividend - res),divisor);
                return flag ? (temp > INT_MAX?INT_MAX:temp) : 0 - temp;
            }
            res = tmp;
            pre = i;
        }
        return 0;
    }
};
// @lc code=end

