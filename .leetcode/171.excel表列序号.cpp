/*
 * @lc app=leetcode.cn id=171 lang=cpp
 *
 * [171] Excel表列序号
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int titleToNumber(string columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for(int i = 0;i < n;i++){
            ans *= 26;
            int tmp = columnTitle[i] - 64;
            ans += tmp;
        }
        return ans;
    }
};
// @lc code=end

