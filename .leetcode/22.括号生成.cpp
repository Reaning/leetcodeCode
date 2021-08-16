/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<string>ans;
    string temp;
    void traversal(int left,int right){
        if(left==0&&right==0){
            ans.push_back(temp);
            return;
        }
        if(left==0){
            string t = temp;
            for(int i = 0;i < right;i++){
                temp = temp + ')';
            }
            ans.push_back(temp);
            temp = t;
            return;
        }
        string t = temp;
        temp = temp + '(';
        traversal(left - 1,right);
        temp = t;
        if(right>left){
            temp = temp + ')';
            traversal(left,right - 1);
            temp = t;
        }
    }
    vector<string> generateParenthesis(int n) {
        traversal(n, n);
        return ans;
    }
};
// @lc code=end

