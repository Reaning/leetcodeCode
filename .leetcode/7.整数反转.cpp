/*
 * @lc app=leetcode.cn id=7 lang=cpp
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        while(x){
            int m = x % 10;
            if((x > 0 && (ans < 214748364 || (ans == 214748364 && m <= 7))) 
            || (x < 0 && (ans > -214748364 || (ans == -214748364 && m >= -8)))){
                ans = ans * 10 + m;
            }else{
                return 0;
            }
            x /= 10;
        }
        return ans;  
    }
};
// @lc code=end

