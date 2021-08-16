/*
 * @lc app=leetcode.cn id=567 lang=cpp
 *
 * [567] 字符串的排列
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        map<char,int>mp1;
        for(auto i : s1)mp1[i]++;
        int left = -1,right = 0;
        int n = s2.size();
        map<char,int>mp2;
        while(right < n){
            if(mp2[s2[right]] == mp1[s2[right]]){
                left++;
                mp2[s2[left]]--;
                while(left < right && s2[left] != s2[right]){
                    left++;
                    mp2[s2[left]]--;
                }
            }
            if(right - left == s1.size())return true;
            mp2[s2[right]]++;
            right++;
        }
        return false;
    }
};
// @lc code=end

