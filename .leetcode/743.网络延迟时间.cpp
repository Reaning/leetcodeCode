/*
 * @lc app=leetcode.cn id=743 lang=cpp
 *
 * [743] 网络延迟时间
 */
#include<bits/stdc++.h>
using namespace std;

// class Solution {
// public:
// using pii = pair<int, int>;
//     int networkDelayTime(vector<vector<int>>& times, int n, int k) {
//         vector<vector<pii> > eg(n+1);
//         vector<int> vis(n+1);
//         int ans = 0;
//         for(auto& x: times){
//             eg[x[0]].emplace_back(x[1], x[2]);
//         }
//         priority_queue<pii, vector<pii>, greater<pii> > q;
//         q.emplace(0, k);
//         while(q.size()){
//             auto [time, now] = q.top();
//             q.pop();
//             if(vis[now])continue;
//             ans = max(ans, time);
//             vis[now] = true;
//             for(auto [next, nextTime]: eg[now]){
//                 if(vis[next] == false) q.emplace(nextTime + time, next);
//             }
//         }
//         return count(begin(vis)+1, end(vis), true) == n ? ans : -1;
//     }
// };

// class Solution {
// public:
//     vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
//         int n = obstacles.size();
//         map<int,vector<int>>mp;
//         vector<int>dp(n,0);
//         dp[0] = 1;
//         for(int i = 1; i < n;i++){
//             dp[i] = 1;
//             mp[obstacles[i]].push_back(i + 1);
//             auto it = mp.find(obstacles[i]);
//             while(it != mp.begin()){
//                 for(int j = 0;j < it->second.size();j++){
//                     dp[i] = max(dp[i],dp[it->second[j] - 1] + 1);
//                 }
//                 it--;
//             }
//             for(int j = 0;j < it->second.size();j++){
//                     dp[i] = max(dp[i],dp[it->second[j] - 1] + 1);
//             }
//         }
//         return dp;
//     }
// };
// class Solution {
// public:
//     long long numberOfWeeks(vector<int>& milestones) {
//         long long best = *max_element(milestones.begin(),milestones.end());
//         long long rest = accumulate(milestones.begin(),milestones.end(),0LL) - best;
//         if(rest + 1 >= best)return best + rest;
//         return 2 * rest + 1;
//     }
// };
// class Solution {
// public:
//     long long minimumPerimeter(long long neededApples) {
//         long long i = 1;
//         long long res = 12;
//         long long cur = 12;
//         while(neededApples > res){
//             cur += (6 + 4 * (i++ - 1)) * 6;
//             res += cur;
//         }
//         return i * 8;
//     }
// };
class Solution {
public:
    int numOfStrings(vector<string>& patterns, string word) {
        unordered_map<char,int>mp;
        int ans = 0;
        int n = patterns.size(),m = word.size();
        for(int i = 0;i < n;i++){
            int index = 0;
            int k = patterns[i].length();
            for(int j = 0;j < m;j++){
                if(word[j] == patterns[i][index]){
                    if(j + k - 1 < m&&word.substr(j,k) == patterns[i]){
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
};
class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        for(int i = n - 2;i >= 1;i--){
            if(2 * nums[i] == nums[i + 1] + nums[i - 1]){
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
        return nums;
    }
};
// @lc code=end

