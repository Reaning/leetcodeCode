/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String ans = strs[0];
        int n = strs.length;
        for(int i = 1;i < n;i++){
            int j;
            for(j = 0;j < ans.length();j++){
                if(j >= strs[i].length()||ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }
}
// @lc code=end

