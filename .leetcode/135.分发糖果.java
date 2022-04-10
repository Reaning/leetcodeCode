import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        List<Integer> minCandy = new ArrayList<>();
        int n = ratings.length;
        int pre = 0;
        int cur = 0;
        for(int i = 1;i < n;i++){
            cur = ratings[i + 1] - ratings[i];
            if(cur > 0 && pre <= 0){
                minCandy.add(i - 1);
            }
            pre = cur;
        }
        if(cur < 0)minCandy.add(n - 1);
        
    }
}
// @lc code=end

