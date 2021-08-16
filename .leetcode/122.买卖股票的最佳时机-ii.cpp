/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        for(int i = 0;i<prices.size()-1;i++){
            int temp = prices[i+1]-prices[i];
            ans = temp>0?temp+ans:ans;
        }
        return ans;
    }
};
// @lc code=end

