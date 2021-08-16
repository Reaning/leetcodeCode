/*
 * @lc app=leetcode.cn id=1941 lang=java
 *
 * [1941] 检查是否所有字符出现次数相同
 */

// @lc code=start
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int n = s.length();
        int[] ans = new int[26];
        for(int i = 0;i < n;i++){
            ans[s.charAt(i) - 'a'] += 1;
        }
        int temp = 0;
        for(int i = 0;i < 26;i++){
            if(temp == 0 && ans[i] > 0)temp = ans[i];
            else if(temp > 0 && ans[i] > 0 && temp != ans[i])return false;
        }
        return true;
    }
}
// @lc code=end

