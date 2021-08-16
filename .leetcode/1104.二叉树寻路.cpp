/*
 * @lc app=leetcode.cn id=1104 lang=cpp
 *
 * [1104] 二叉树寻路
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int>ans;
    void count(int n,int pos){
        if(n == 0)return;
        int c = n%2?0:pow(2,n - 1) - 1;
        int begin = pow(2,n - 1);
        int label = n % 2?begin + pos:begin + c - pos;
        ans.insert(ans.begin(),label);
        count(n - 1,pos /2);
    }
    vector<int> pathInZigZagTree(int label) {
        int k = log2(label);
        int n = k + 1;
        for(n;  n >= k; n--){
            if(pow(2,n) - 1>=label && pow(2,n - 1) <= label)break;
        }
        ans.insert(ans.begin(),label);
        int c = n%2?0:pow(2,n - 1) - 1;
        int rel = label - pow(2,n - 1);
        c = n % 2?rel:c - rel;
        int next = c / 2;
        count(n - 1,next);
        return ans;
    }
};
// @lc code=end

