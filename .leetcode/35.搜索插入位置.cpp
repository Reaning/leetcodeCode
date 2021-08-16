/*
 * @lc app=leetcode.cn id=35 lang=cpp
 *
 * [35] 搜索插入位置
 */
// @lc code=start

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
	int searchInsert(vector<int>& nums, int target) {
		int n = nums.size();
		int left = 0, right = n - 1, ans = n;
		while (left <= right) {
			int temp = left + (right - left) / 2;
			if (target <= nums[temp]) {
				right = temp - 1;
				ans = temp;
			}
			else left = temp + 1;
		}
		return ans;
	}
};
// @lc code=end

