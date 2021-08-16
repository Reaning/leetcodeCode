/*
 * @lc app=leetcode.cn id=1846 lang=cpp
 *
 * [1846] 减小和重新排列数组后的最大元素
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int>& arr) {
	sort(arr.begin(),arr.end());
	int left = 0;
	int n = arr.size();
	int cur = 0;
	while(left < n){
		while(left < n && arr[left] == cur){	
			left++;
		}
		if(left == n && arr[left - 1]==cur)break;
		arr[left++] = ++cur;
	}
	return arr[n - 1];
    }
};
// @lc code=end

