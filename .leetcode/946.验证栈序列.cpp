/*
 * @lc app=leetcode.cn id=946 lang=cpp
 *
 * [946] 验证栈序列
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        if(pushed.size() == 0)return true;
        stack<int>stk;
        unordered_map<int,int>mp;
        stk.push(pushed[0]);
        int ltop = 1,rtop = 0;
        while(true){
            if(stk.size() && stk.top() == popped[rtop]){
                stk.pop();
                rtop++;
            }
            else{
                if(ltop < pushed.size()){
                    stk.push(pushed[ltop]);
                    ltop++;
                }else if(ltop == pushed.size() && rtop == popped.size() && stk.empty()){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
};
// @lc code=end

