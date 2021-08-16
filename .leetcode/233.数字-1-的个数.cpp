/*
 * @lc app=leetcode.cn id=233 lang=cpp
 *
 * [233] 数字 1 的个数
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int countDigitOne(int n) {
        int ans = 0;
        int index = 0;
        int copy = n;
        while (n)
        {
            int cur = n % 10;
            n/=10;
            int temp = n;
            int k = 1;
            for(int i = 0;i < index;i++){
                k *= 10;
            }
            int pre = copy % k;
            if(cur > 1){
                temp += 1;
                ans += temp * pow(10,index++);
            }
            else if(cur == 1){
                ans += pre + 1 + temp * pow(10,index++);
            }else{
                ans += temp * pow(10,index++);
            }
            pre = cur;
        }
        return ans;
    }
};
// @lc code=end

