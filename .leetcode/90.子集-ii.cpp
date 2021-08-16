/*
 * @lc app=leetcode.cn id=90 lang=cpp
 *
 * [90] 子集 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>>ans;
    vector<int>temp;
    void backtracking(vector<int>& numbers,int index,unordered_map<int,int>& mp){
        if(index >= numbers.size()){
            ans.push_back(temp);
            return;
        }
        backtracking(numbers,index + 1,mp);
        int n = mp[numbers[index]];
        for(int i = 0; i < n;i++){
            temp.push_back(numbers[index]);
            backtracking(numbers,index + 1,mp);
        }
        while(n--){
            temp.pop_back();
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        int n = nums.size();
        vector<int>number;
        unordered_map<int,int>mp;
        for(int i = 0; i < n;i++){
            if(mp[nums[i]])mp[nums[i]]++;
            else{
                mp[nums[i]]++;
                number.push_back(nums[i]);
            }
        }
        backtracking(number,0,mp);
        return ans;
    }
};
// @lc code=end

