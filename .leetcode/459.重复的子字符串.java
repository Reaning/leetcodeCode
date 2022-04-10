import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int left = -1;
        int[] next = new int[n];
        next[0] = left;
        for(int i = 1; i < n;i++){
            while(left >= 0 && s.charAt(left + 1) != s.charAt(i)){
                left = next[left];
            }
            if(s.charAt(left + 1) == s.charAt(i)){
                left++;
            }
            next[i] = left;
        }
        if(next[n - 1] == -1)return false;
        if(n % (n - next[n - 1] - 1) == 0){
            return true;
        }
        return false;
    }
}
// @lc code=end

