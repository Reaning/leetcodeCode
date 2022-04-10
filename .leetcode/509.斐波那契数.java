/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if(n < 2)return n;
        int pre = 0;
        int cur = 1;
        for(int i = 2; i <= n;i++){
            int temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }
}
// @lc code=end

