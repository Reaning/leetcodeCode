/*
 * @lc app=leetcode.cn id=726 lang=cpp
 *
 * [726] 原子的数量
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    bool isNum(char a) {
        if (a >= '1' && a <= '9')return true;
        return false;
    }
    string noBrackets(string formula, int times) {
        stack<char>stk;
        int t = 0;
        int length = formula.size();
        string num = "";
        string temp = "";
        for (int i = 0; i < length; i++)
        {
            stk.push(formula[i]);
            if (formula[i] >= '1' && formula[i] <= '9') {
                if (i + 1 != length && (formula[i + 1] >= '1' && formula[i + 1] <= '9'))continue;
                else {
                    while (stk.top() <= '9' && stk.top() >= '1') {
                        num = stk.top() + num;
                        stk.pop();
                    }
                    if (stk.top() == ')') {
                        stk.pop();
                        while (stk.top() != '(') {
                            temp = stk.top() + temp;
                            stk.pop();
                        }
                        stk.pop();
                        string t = noBrackets(temp, stoi(num) * times);
                        for (int j = 0;j < t.size();j++) {
                            stk.push(t[j]);
                        }
                    }
                    else {
                        string t = to_string(stoi(num) * times);
                        for (int j = 0;j < t.size();j++) {
                            stk.push(t[j]);
                        }
                    }
                    num = "";
                    temp = "";
                }
            }
            else {
                if (i + 1 == length || (((formula[i + 1] >= 65 && formula[i + 1] <= 90) || formula[i + 1] == '(') && formula[i] != '('))stk.push('1');
            }
        }
        string ans = "";
        while (!stk.empty()) {
            ans = stk.top() + ans;
            stk.pop();
        }
        return ans;
    }
    string countOfAtoms(string formula) {
        string nobrackets = noBrackets(formula, 1);
        map<string, int>mp;
        int length = nobrackets.size();
        for (int i = 0;i < length;i++) {
            if ((i + 1 == length || !isNum(nobrackets[i + 1])) && (isNum(nobrackets[i]))) {
                int j;
                for (j = i;j >= 0;j--) {
                    if (!isNum(nobrackets[j]))break;
                }
                int k;
                for (k = j;k >= 0;k--) {
                    if (isNum(nobrackets[i]))break;
                }
                string str;
                str = nobrackets.substr(k + 1, j - k + 1);
                mp[str] += stoi(nobrackets.substr(j + 1, i - j));
            }
        }
        string ans = "";
        for (auto it = mp.begin();it != mp.end();it++) {
            ans = ans + it->first + to_string(it->second);
        }
        return ans;
    }
};
// @lc code=end

