/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == right)return left & right;
        if(left == 0 || left == 1)return 0;
        int a = left,b = right,prea = left,preb = right;
        int a1 = 1,b1 = 1;
        int ans = 0;
        while(true){
            if(a == b)return a & b;
            if(a == 0 || a == 1)break;
            a >>= 1;
            while(a > 0){
                a1 <<= 1;
                a >>= 1;
            }
            b >>= 1;
            while(b > 0){
                b1 <<= 1;
                b >>= 1;
            }
            if(b1 > a1)break;
            ans += b1;
            a = prea - b1;
            b = preb - b1;
            a1 = 1;
            b1 = 1;
            prea = a;
            preb = b;
        }
        return ans;
    }
}
// @lc code=end

