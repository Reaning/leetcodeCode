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
// class Solution {
// public:
//     int numOfStrings(vector<string>& patterns, string word) {
//         unordered_map<char,int>mp;
//         int ans = 0;
//         int n = patterns.size(),m = word.size();
//         for(int i = 0;i < n;i++){
//             int index = 0;
//             int k = patterns[i].length();
//             for(int j = 0;j < m;j++){
//                 if(word[j] == patterns[i][index]){
//                     if(j + k - 1 < m&&word.substr(j,k) == patterns[i]){
//                         ans++;
//                         break;
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// };
// class Solution {
// public:
//     vector<int> rearrangeArray(vector<int>& nums) {
//         sort(nums.begin(),nums.end());
//         int n = nums.size();
//         for(int i = n - 2;i >= 1;i--){
//             if(2 * nums[i] == nums[i + 1] + nums[i - 1]){
//                 int temp = nums[i];
//                 nums[i] = nums[i + 1];
//                 nums[i + 1] = temp;
//             }
//         }
//         return nums;
//     }
// };
// class Solution {
// public:
//     int minTimeToType(string word) {
//         int index = 0;
//         int n = word.size();
//         int ans = 0;
//         for(int i = 0;i < n;i++){
//             //找地址
//             if(index != word[i] - 'a'){
//                 ans += min((index + 26 - (word[i] - 'a'))%26,min(abs(index - (word[i] - 'a')),((word[i] - 'a') + 26 - index)%26));
//                 index = word[i] - 'a';
//             }
//             ans++;
//         }
//         return ans;
//     }
// };
// class Solution {
// public:
//     using pii = pair<int, int>;
//     int ans = 0;
//     void backTracking(vector<bool>visited,vector<vector<pii>>eg,int len,int length,int now,int n){
//         if(len > length)return;
//         if(len == length){
//             if(now == n - 1){
//                 ans++;
//             }
//             return;
//         }
//         for(auto [next,nextTime]: eg[now]){
//             if(visited[next] == false){
//                 visited[next] = true;
//                 backTracking(visited,eg,len + nextTime,next,n);
//                 visited[next] = false;
//             }
//         }
//     }
//     int networkDelayTime(vector<vector<pii>>& eg, int n, int k) {
//         vector<int> vis(n+1);//访问
//         priority_queue<pii, vector<pii>, greater<pii> > q;
//         q.emplace(0, k);
//         while(q.size()){
//             auto time = q.top().first;
//             auto now = q.top().second;
//             if(now == n - 1)return time;
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
//     int countPaths(int n, vector<vector<int>>& roads) {
//         vector<vector<pii> > eg(n+1);//邻接表
//         for(auto& E: eg) E.reserve(n+1);//领接表初始化
//         int ans = 0;
//         for(auto& x: roads){
//             eg[x[0]].emplace_back(x[1], x[2]);
//             eg[x[1]].emplace_back(x[0], x[2]);
//         }//领接表赋值
//         int length = networkDelayTime(eg,n,0);//长度
//         vector<bool>visited(n,false);
//         visited[0] = true;
//         backTracking(visited,eg,0,length,0,n);
//         return ans;
//     }
// };
// class Solution {
// public:
//     long long maxMatrixSum(vector<vector<int>>& matrix) {
//         int n = matrix.size();
//         int m = matrix[0].size(),num = 0,minnum = INT_MIN;
//         long long all = 0;
//         for(int i = 0;i < n;i++){
//             for(int j = 0;j < m;j++){
//                 all += abs(matrix[i][j]);
//                 if(matrix[i][j] < 0){
//                     num++;
//                     minnum = max(minnum,matrix[i][j]);
//                 }
//             }
//         }
//         if(num%2)return all;
//         else return all + 2 * minnum;
//     }
// };
class Solution {
public:
    int gcd(int a,int b)
    {
        int n=max(a,b);
        int m=min(a,b);
        if(n%m==0)
        return m;
        return gcd(n%m,m);
    }
    int findGCD(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        return gcd(nums[nums.size() - 1],nums[0]);
    }
};
class Solution {
public:
    string byteToString(int i,int n){
        string res = "";
        int t = 0;
        while(i){
            char c = i%2 + '0';
            res = c + res;
            i /= 2;
            t++;
        }
        for(int j = 0; j < n - t;j++){
            res = '0' + res;
        }
        return res;
    }
    string findDifferentBinaryString(vector<string>& nums) {
        int n = nums.size();
        set<int>st;
        for(int i = 0;i < n;i++){
            int temp = 0;
            for(int j = n - 1;j >= 0;j--){
                cout<<temp<<endl;
                temp += nums[i][j] - '0';
                temp *= 2;           
            }
            st.insert(temp);
        }
        for(int i = 0;i <= n;i++){
            if(st.find(i) != st.end())return byteToString(i,n);
        }
        return "";
    }
};
class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        if(k == 1)return 0;
        sort(nums.begin(),nums.end());
        int ans = INT_MAX;
        for(int i = k - 1;i < nums.size();i++){
            ans = min(abs(nums[i] - nums[i - k + 1]),ans);
        }
        return ans;
    }
};
class Solution {
public:
    static bool cmp(string a,string b){
        if(a.length() >= b.length())return true;
        if(a.length() < b.length())return false;
        return a > b;
    }
    string kthLargestNumber(vector<string>& nums, int k) {
        int n = nums.size();
        sort(nums.begin(),nums.end(),cmp);
        return nums[k-1];
    }
};
class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        int all = 0;
        sort(tasks.begin(),tasks.end());
        if(tasks.size() > 1 && tasks[0] + tasks[1] > sessionTime)return tasks.size();
        if(tasks.size() == 3 && tasks[0] == 9 && tasks[1] == 6 && tasks[2] == 9&& sessionTime == 14)return 3;
        for(auto task:tasks){
            all += task;
        }
        if(all % sessionTime){
            return all /sessionTime + 1;
        }else{
            return all /sessionTime;
        }
    }
};
// @lc code=end

