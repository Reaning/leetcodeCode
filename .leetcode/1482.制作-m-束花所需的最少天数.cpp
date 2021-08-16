/*
 * @lc app=leetcode.cn id=1482 lang=cpp
 *
 * [1482] 制作 m 束花所需的最少天数
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int getflower(vector<int>& bloomDay,int day,int m,int k){
        int t = 0;
        int f = 0;
        vector<int>flower(bloomDay.size(),false);
        for(int i = 0;i<flower.size();i++){
            if(bloomDay[i]<=day)flower[i]=true;
            if(flower[i]){
                t++;
                if(t==k){
                    f++;
                    t=0;
                }
            }else t=0;
        }
        return f;
    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        long num = m*k;
        if(bloomDay.size()<num)return -1;
        int maxday = *max_element(bloomDay.begin(),bloomDay.end());
        int right = maxday;
        if(bloomDay.size()==num)return right;
        int left = *min_element(bloomDay.begin(),bloomDay.end());
        while(left<right){
            int mid = (right - left)/2+left;
            if(getflower(bloomDay,mid,m,k)>=m)right = mid;
            else left = mid+1;
        }
        return left;
    }
};
// @lc code=end

