/*
 * @lc app=leetcode.cn id=343 lang=cpp
 *
 * [343] 整数拆分
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int integerBreak(int n) {
        if(n==1||n==2)return 1;
        vector<int>nums(n,1);
        for(int i = 3;i<=n;i++){
            for(int j = 1;j<i;j++){
                nums[i-1] = max(max((i-j)*j,(j-1)*nums[i-j]),nums[i - 1]);
            }
        }
        for(auto i:nums)cout<<i<<" ";
        cout<<endl;
        return nums[n-1];
    }
};
// @lc code=end

