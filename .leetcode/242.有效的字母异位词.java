import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer>mp = new HashMap<>();
        Map<Character,Integer>mp1 = new HashMap<>();
        int m = s.length(),n = t.length();
        if(m != n)return false;
        for(int i = 0; i < m;i++){
            Character c = s.charAt(i);
            if(mp.containsKey(c)){
                mp.replace(c,mp.get(c) + 1);
            }else{
                mp.put(c, 1);
            }
            c = t.charAt(i);
            if(mp1.containsKey(c)){
                mp1.replace(c,mp1.get(c) + 1);
            }else{
                mp1.put(c, 1);
            }
        }
        return mp.equals(mp1);
    }
}
// @lc code=end

