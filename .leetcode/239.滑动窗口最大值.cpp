/*
 * @lc app=leetcode.cn id=239 lang=cpp
 *
 * [239] 滑动窗口最大值
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        priority_queue<pair<int,int>>q;
        vector<int>ans;
        int n = nums.size();
        for(int i = 0;i < k; i++){
            q.emplace(nums[i],i);
        }
        ans.push_back(q.top().first);
        int left = 0,right = left + k - 1;
        while(right + 1< n){
            right++;
            left++;
            q.emplace(nums[right],right);
            while(q.top().second < left){
                q.pop();
            }
            ans.push_back(q.top().first);
        }
        return ans;
    }
};
// @lc code=end

