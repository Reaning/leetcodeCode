/*
 * @lc app=leetcode.cn id=844 lang=cpp
 *
 * [844] 比较含退格的字符串
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    string nobackspace(string s){
        int n = s.length();
        string ans = "";
        int left = 0,right = 0;
        for(int i = 0; i < n;i++){
            if(s[i] == '#'){
                if(ans.length())ans = ans.substr(0,ans.length() - 1);
            }else{
                ans = ans + s[i];
            }
        }
        return ans;
    }
    bool backspaceCompare(string s, string t) {
        return nobackspace(s) == nobackspace(t);
    }
};
// @lc code=end

