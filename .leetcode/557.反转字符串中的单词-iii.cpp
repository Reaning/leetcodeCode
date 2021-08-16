/*
 * @lc app=leetcode.cn id=557 lang=cpp
 *
 * [557] 反转字符串中的单词 III
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    void reverse(string& s, int left,int right){
        while(left<right){
            // swap(s[left],s[right]);
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    string reverseWords(string s) {
        int pre = 0;
        int size = s.size();
        for(int i = 0; i<size;i++){
            if(s[i]==' '){
                int left = pre;
                int right = i - 1;
                while(left<right){
                    // swap(s[left],s[right]);
                    char temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                    left++;
                    right--;
                }
                pre = i+1;
            }
        }
        reverse(s,pre,size - 1);
        return s;
    }
};
// @lc code=end

