/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)return false;
        int temp = x;
        int ans = 0;
        while(x != 0){
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans == temp;
    }
}
// @lc code=end

