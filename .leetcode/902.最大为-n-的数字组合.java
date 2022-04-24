/*
 * @lc app=leetcode.cn id=902 lang=java
 *
 * [902] 最大为 N 的数字组合
 */

// @lc code=start
class Solution {
    public void reverse(char[] chars){
        int n = chars.length;
        int left = 0,right = n - 1;
        while(left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int m = digits.length;
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int x = chars.length;
        int[] dp = new int[x + 1];
        reverse(chars);
        dp[0] = 1;
        for(int i = 1;i <= x;i++){
            int t = chars[i - 1] - '0';
            for(String s:digits){
                if(Integer.parseInt(s) < t){
                    //如果当前的数字比当前数位要小，则前面数位可以为任意值，即m^i-1
                    dp[i] += Math.pow(m, i - 1);
                }else if(Integer.parseInt(s) == t){
                    //如果当前数字等于当前数位，则判断之前数位的情况，而这个情况在前面已经考虑过
                    //当前数字等于的话，需要判断前面数字，前面一位数字相等/不相等的情况，也就是dp[i-1]
                    dp[i] += dp[i - 1];
                }
            }
        }
        for(int i = 1;i < x;i++){
            //计算错位的数字
            //因为之前计算的都是按照当前位数考虑的，如第5位只考虑长度为5的数字
            //因此要加上小于总长度的所有组合
            dp[x] += Math.pow(m, i);
        }
        return dp[x];
    }
}
// @lc code=end

