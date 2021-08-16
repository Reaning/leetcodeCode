/*
 * @lc app=leetcode.cn id=14 lang=cpp
 *
 * [14] 最长公共前缀
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string same = "";
        if(!strs.size())return same;
        same = strs[0];
        if(strs.size()==1)return same;
        int n = strs.size();
        for(int i = 1;i < n;i++){
            int length = min(same.size(),strs[i].size());
            int j = 0;
            for(j;j < length;j++){
                if(same[j] != strs[i][j]){
                    break;
                }
            }
            same = same.substr(0,j);
        }
        return same;
    }
};
// @lc code=end

