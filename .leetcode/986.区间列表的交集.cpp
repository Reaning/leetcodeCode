/*
 * @lc app=leetcode.cn id=986 lang=cpp
 *
 * [986] 区间列表的交集
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        int left = 0,right = 0;
        int m  = firstList.size(),n = secondList.size();
        vector<vector<int>>ans;
        while(left < m && right < n){
            if(firstList[left][1] >= secondList[right][0] && firstList[left][0] <= secondList[right][1]){
                if(firstList[left][1] <= secondList[right][1]){
                    if(secondList[right][0] > firstList[left][0])
                    ans.push_back({secondList[right][0],firstList[left][1]});
                    else
                    ans.push_back(firstList[left]);
                    left++;
                }
                else if(firstList[left][1] > secondList[right][1]){
                    if(firstList[left][0] <= secondList[right][0])
                    ans.push_back(secondList[right]);
                    else
                    ans.push_back({firstList[left][0],secondList[right][1]});
                    right++;
                }
            }else if(firstList[left][1] >= secondList[right][0]){
                right++;
            }else{
                left++;
            }
        }
        return ans;
    }
};
// @lc code=end

