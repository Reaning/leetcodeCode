import java.util.List;

import javax.sound.sampled.SourceDataLine;

/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int index = 0;
        int[]ans = new int[n];
        for(int i = 0;i < n;i++){
            if(index + 1 < list.size()){
                int left = Math.abs(i - list.get(index));
                int right = Math.abs(i - list.get(index + 1));
                if(right < left){
                    index++;
                }
                ans[i] = Math.min(left, right);
            }else{
                ans[i] = Math.abs(i - list.get(index));
            }
        }
        return ans;
    }
}
// @lc code=end

