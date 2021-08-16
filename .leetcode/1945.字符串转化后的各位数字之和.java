/*
 * @lc app=leetcode.cn id=1945 lang=java
 *
 * [1945] 字符串转化后的各位数字之和
 */

// @lc code=start
class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        String temp = "";
        for(int i = 0;i < n;i++){
            temp = temp + Integer.toString(s.charAt(i) - 'a' + 1);
        }
        s = temp;
        int ans = 0;
        while(k-- > 0){
            int m = s.length();
            ans = 0;
            for(int i = 0;i < m;i++){
                ans += s.charAt(i) - '0';
            }
            s = Integer.toString(ans);
        }
        return ans;
    }
}
// @lc code=end

