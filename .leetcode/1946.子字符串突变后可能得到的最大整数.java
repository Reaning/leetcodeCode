import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1946 lang=java
 *
 * [1946] 子字符串突变后可能得到的最大整数
 */

// @lc code=start
class Solution {
    public String maximumNumber(String num, int[] change) {
       int n = num.length();
       char[] s = num.toCharArray();
       for(int i = 0;i < n;i++){
           int temp = s[i] - '0';
           if(change[temp] > temp){
               s[i] = (char)(change[temp] + '0');
               i++;
               while(i < n && change[s[i] - '0'] >= s[i] - '0'){
                    s[i] = (char)(change[s[i] - '0'] + '0');
                    i++;
               }
               num = Arrays.toString(s).replaceAll("[\\[\\]\\s,]", "");
               return num;
           }
       } 
       return num;
    }
}
// @lc code=end

