import java.util.Deque;
import java.util.LinkedList;

import javax.print.attribute.standard.NumberUpSupported;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        Deque<int[]>st = new LinkedList<>();
        int n = height.length;
        int ans = 0;
        for(int i = 0;i < n;i++){
            if(st.isEmpty() && height[i] == 0)continue;
            if(st.isEmpty())st.push(new int[]{height[i],i});
            else{
                int[]temp = st.peek();
                if(temp[0] > height[i]){
                    st.push(new int[]{height[i],i});
                }else{
                    int mid = 0;
                    while(!st.isEmpty() && temp[0] <= height[i]){
                        ans += (temp[0] - mid) * (i - temp[1] - 1);
                        mid = temp[0];
                        st.poll();
                        temp = st.peek();
                    }
                    if(!st.isEmpty())ans += (height[i] - mid) * (i - temp[1] - 1);
                    st.push(new int[]{height[i],i});
                }
            }
            System.out.println(ans);
        }
        return ans;
    }
}
// @lc code=end

