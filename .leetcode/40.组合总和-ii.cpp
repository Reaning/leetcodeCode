/*
 * @lc app=leetcode.cn id=40 lang=cpp
 *
 * [40] 组合总和 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>>ans;
    vector<int>temp;
    vector<pair<int,int>>freq;
    void traversal(int begin,int target){
        if(target==0){
            ans.push_back(temp);
            return;
        }
        if(begin == freq.size()||target < freq[begin].first)return;
        traversal(begin + 1,target);
        int most = min(target/freq[begin].first,freq[begin].second);
        for(int i = 1;i <= most;i++){
            temp.push_back(freq[begin].first);
            traversal(begin + 1,target - i * freq[begin].first);
        }
        for(int i = 0;i < most;i++)temp.pop_back();
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        for(auto i:candidates){
            if(freq.empty()||freq.back().first!=i)
                freq.emplace_back(i,1);
            else
                freq.back().second++;
        }
        traversal(0,target);
        return ans;
    }
};
// @lc code=end

