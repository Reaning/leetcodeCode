/*
 * @lc app=leetcode.cn id=264 lang=cpp
 *
 * [264] 丑数 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int nthUglyNumber(int n) {
        if(n == 1)return 1;
        priority_queue<int,vector<int>,greater<int>>q;
        q.push(2);
        q.push(3);
        q.push(5);
        int index = -1;
        int i = 2;
        while(true){
            index++;
            int temp = q.top();
            q.pop();
            if(index == n)return temp; 
            if(i <=563){
                q.push(temp*2);
                q.push(temp*3);
                q.push(temp*5);
            }
        }
       return index;
    }
};
// @lc code=end

