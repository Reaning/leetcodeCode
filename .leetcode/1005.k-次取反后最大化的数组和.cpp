/*
 * @lc app=leetcode.cn id=1005 lang=cpp
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int largestSumAfterKNegations(vector<int>& A, int K) {
        sort(A.begin(),A.end());
        int i = 0;
        for(i;A[i]<0;i++);
        int f = i;
        if(A[0]>=0)f=-1;
        int sum = 0;
        for(i;i<A.size();i++)sum+=A[i];
        if(K<f){
            for(i=0;i<=f-K;i++){
                sum+=-A[i];
            }
            for(i;i<f;i++)sum+=A[i];
            return sum;
        }else{
            if(f==-1){
                sum-=(K)%2?2*A[0]:0;
            }else{
            for(i = 0;i<f;i++)sum+=-A[i];
            sum+=(K-f)%2?A[f-1]:0;
            return sum;
            }
        }
        return sum;
    }
};
// @lc code=end

