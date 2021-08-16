/*
 * @lc app=leetcode.cn id=455 lang=cpp
 *
 * [455] 分发饼干
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        int j = g.size() - 1;
        int ans = 0;
        for(int i = s.size()-1;i>=0;i--){
            for(j;j>=0;j--){
                if(s[i]>=g[j]){
                    ans++;
                    j--;
                    break;
                }
            }
        }
        return ans;
    }
};
// @lc code=end

