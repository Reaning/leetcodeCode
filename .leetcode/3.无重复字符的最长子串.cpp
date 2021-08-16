/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char>str;
        int left = -1,right = 0;
        int n = s.size();
        int ans = 0;
        while(right < n){
            if(str.count(s[right])){
                left++;
                str.erase(s[left]);
                while(left < right && s[left] != s[right]){
                    left++;
                    str.erase(s[left]);
                }
                if(str.count(s[left]))str.erase(s[left]);
            }
            int temp = right - left;
            ans = max(ans,temp);
            str.insert(s[right]);
            right++;
        }
        return ans;
    }
};
// @lc code=end

