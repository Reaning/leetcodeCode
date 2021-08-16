/*
 * @lc app=leetcode.cn id=438 lang=cpp
 *
 * [438] 找到字符串中所有字母异位词
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if(p.size() > s.size()||s.size() == 0)return {};
        int n = s.size();
        // unordered_map<char,int>key;
        // unordered_map<char,int>tmp;
        vector<int>key(128);
        vector<int>tmp(128);
        vector<int>ans;
        for(auto i : p) key[i]++;
        for(int i=0;i<p.size()-1;i++) tmp[s[i]]++;
        int l=0,r=p.size()-1;//窗口是[l,r]
        while(r<n)
        {
            tmp[s[r++]]++;
            if(key==tmp) ans.push_back(l);
            tmp[s[l++]]--;
        }
        return ans;
    }
};
// @lc code=end

