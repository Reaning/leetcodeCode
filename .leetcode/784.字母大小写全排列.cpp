/*
 * @lc app=leetcode.cn id=784 lang=cpp
 *
 * [784] 字母大小写全排列
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    string temp;
    vector<string>ans;
    vector<bool>letter;
    bool isLetter(char a){
        if((a >= 'A' && a <= 'Z') || (a >='a' && a <= 'z'))return true;
        return false;
    }
    char reverseLetter(char a){
        if(a >= 'A' && a <= 'Z')return a + 32;
        return a - 32;
    }
    void dfs(int n,int i,string s){
        if(temp.length() == n){
            ans.push_back(temp);
            return;
        }
        if(letter[i] == false){
            string tmp = temp;
            temp = temp + s[i];
            dfs(n,i + 1,s);
            temp = tmp;
        }else{
            string tmp = temp;
            temp = temp + s[i];
            dfs(n,i + 1,s);
            temp = tmp;
            temp = temp + reverseLetter(s[i]);
            dfs(n,i + 1,s);
            temp = tmp;
        }
    }
    vector<string> letterCasePermutation(string s) {
        int n = s.length();
        letter.resize(n);
        for(int i = 0;i < n;i++){
            if(isLetter(s[i]))letter[i] = true;
            else letter[i] = false;
        }
        dfs(n,0,s);
        return ans;
    }
};
// @lc code=end

