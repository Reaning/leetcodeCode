/*
 * @lc app=leetcode.cn id=496 lang=cpp
 *
 * [496] 下一个更大元素 I
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        map<int,int>mp;
        int n = nums1.size();
        for(int i = 0;i < n;i++){
            mp[nums1[i]] = i + 1;
        }
        vector<int>ans(n);
        stack<int>st;
        for(int i : nums2){
            if(st.empty()||i < st.top()){
                st.push(i);
            }
            else{
                while(st.size() && i > st.top()){
                    if(mp[st.top()]){
                        ans[mp[st.top()] - 1] = i;
                    }
                    st.pop();
                }
                st.push(i);
            }
        }
        while(st.size()){
            if(mp[st.top()]){
                ans[mp[st.top()] - 1] = -1;
            }
            st.pop();
        }
        return ans;
    }
};
// @lc code=end

