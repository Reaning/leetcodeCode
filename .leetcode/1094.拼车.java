import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer>mp = new HashMap<>();
        for(int[]trip : trips){
            int num = trip[0],l = trip[1],r = trip[2];
            if(!mp.containsKey(l))mp.put(l, 0);
            mp.put(l, mp.get(l) + num);
            if(!mp.containsKey(r))mp.put(r, 0);
            mp.put(r, mp.get(r) - num);
        }
        List<Event> temp = new ArrayList<>();
        for(int key : mp.keySet()){
            temp.add(new Event(key, mp.get(key)));
        }
        Collections.sort(temp,(a,b) -> a.index - b.index);
        int n = temp.size();
        if(temp.get(0).num > capacity)return false;
        for(int i = 1;i < n;i++){
            temp.get(i).num += temp.get(i - 1).num;
            if(temp.get(i).num > capacity)return false;
        }
        return true;
    }
    class Event{
        public int index;
        public int num;
        Event(int index,int num){
            this.index = index;
            this.num = num;
        }
    }
}
// @lc code=end

