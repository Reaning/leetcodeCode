import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int len = 0;
        // 计算最大值的长度
        while(maxNum > 0){
            len++;
            maxNum /= 10;
        }
        int[]count = new int[10];
        int n = nums.length;
        int[]arr = new int[n];
        int diff = 1;
        for(int i = 0;i < len;i++){
            // 计数，每一位有多少个
            for(int j = 0;j < n;j++){
                count[nums[j] / diff % 10]++;
            }
            int pre = 0;
            // 前缀计数数组，表示前面有多少个比它小的
            for(int j = 0;j < 10;j++){
                int temp = count[j];
                count[j] = pre;
                pre += temp;
            }
            // 计数排序,找到当前这个数字前面有多少个比它小的，放在那个位置
            for(int j = 0;j < n;j++){
                int v = nums[j] / diff % 10;
                arr[count[v]] = nums[j];
                count[v]++;
            }
            diff *= 10;
            // 重新清零，继续计数
            Arrays.fill(count, 0);
            // 将按基数排序好的数组复制到原数组中，下次再继续排序
            System.arraycopy(arr, 0, nums, 0, n);
        }
        int ans = 0;
        for(int i = 0;i < n - 1;i++){
            ans = Math.max(arr[i + 1] - arr[i], ans);
        }
        return ans;
    }
}
// @lc code=end

