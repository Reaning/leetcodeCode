/*
 * @lc app=leetcode.cn id=2211 lang=java
 *
 * [2211] 统计道路上的碰撞次数
 */

// @lc code=start
class Solution {
    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int n = chars.length;
        int ans = 0;
        for(int i = 1;i < n;i++){
            if(chars[i] == 'L'){
                if(chars[i - 1] == 'R'){
                    chars[i] = 'S';
                    chars[i - 1] = 'S';
                    ans+=2;
                    int j = i - 2;
                    while(j >= 0 && chars[j] == 'R'){
                        ans++;
                        j--;
                    }
                }else if(chars[i - 1] == 'S'){
                    chars[i] = 'S';
                    ans++;
                }
            }else if(chars[i] == 'S'){
                if(chars[i - 1] == 'R'){
                    chars[i - 1] = 'S';
                    ans++;
                }
                int j = i - 2;
                while(j >= 0 && chars[j] == 'R'){
                    ans++;
                    j--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

