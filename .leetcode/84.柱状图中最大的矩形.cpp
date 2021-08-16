/*
 * @lc app=leetcode.cn id=84 lang=cpp
 *
 * [84] 柱状图中最大的矩形
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int>st;
        heights.push_back(-1);
        int n = heights.size();
        int ans = 0,top;
        for(int i = 0;i < n;i++){
            if(st.empty() || heights[i] >= heights[st.top()]){
                st.push(i);
            }
            else{
                while(st.size()&&heights[st.top()] > heights[i]){
                    top = st.top();
                    ans = max(ans,(i - top)*heights[top]);
                    st.pop();
                }
                st.push(top);
                heights[top] = heights[i];
            }
        }
        return ans;
    }
};
// @lc code=end

