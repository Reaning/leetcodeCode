import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jdk.internal.net.http.common.Pair;

/*
 * @lc app=leetcode.cn id=1943 lang=java
 *
 * [1943] 描述绘画结果
 */

// @lc code=start
class Solution {

    public List<List<Long>> splitPainting(int[][] segments) {
        int n = segments.length;
        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] seg = segments[i];
            // event type 1: 起点， 2：终点
            eventList.add(new Event(1, seg[0], seg[2]));
            eventList.add(new Event(2, seg[1], seg[2]));
        }
        eventList.sort((a, b) -> a.val != b.val ? a.val - b.val : b.type - a.type);

        List<List<Long>> ret = new ArrayList<>();
        Set<Integer> seenStarts = new HashSet<>();
        Set<Integer> seenEnds = new HashSet<>();
        long start = -1;
        long totalColor = 0;
        for (Event event : eventList) {
            if (event.type == 1) { //区间起点
                if (!seenStarts.contains(event.val)) {
                    if (start != -1 && start < event.val) {
                        ret.add(Arrays.asList(start, (long) event.val, totalColor));
                    }
                    start = event.val;
                    seenStarts.add(event.val);
                }
                totalColor += event.color;
            } else { // 区间终点
                if (!seenEnds.contains(event.val)) {
                    ret.add(Arrays.asList(start, (long) event.val, totalColor));
                    start = event.val;
                    seenEnds.add(event.val);
                }
                totalColor -= event.color;
                if (totalColor == 0) {
                    start = -1;
                }
            }
        }
        return ret;
    }

    class Event {
        int type;
        int val;
        long color;

        public Event(int type, int val, long color) {
            this.type = type; // 1: 起点； 2: 终点
            this.val = val; 
            this.color = color;
        }
    }
}
// @lc code=end

