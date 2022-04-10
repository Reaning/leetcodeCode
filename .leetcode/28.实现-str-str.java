import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int m = haystack.length(),n = needle.length();
        int[] next = new int [n];
        int left = 0;
        next[0] = left;
        for(int i = 1; i < n;i++){
            while(left > 0 && needle.charAt(i) != needle.charAt(left)){
                left = next[left - 1];
            }
            if(needle.charAt(left) == needle.charAt(i)){
                left++;   
            }
            next[i] = left;
        }
        int begin = 0;
        for(int i = 0; i < m;i++){
            while(begin > 0 && needle.charAt(begin) != haystack.charAt(i)){
                begin = next[begin - 1];
            }
            if(needle.charAt(begin) == haystack.charAt(i)){
                begin++;
            }
            if(begin == n)return i - n + 1;
        }
        return -1;
    }
}
// @lc code=end

