import javax.swing.text.AbstractDocument.LeafElement;

/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public void reverse(char[]array,int left,int end,int k){
        int n = array.length;
        int right;
        if(left + k <= n){
            right = left + k - 1;
        }else{
            right = n - 1;
        }
        while(left < right){
            char temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
    }
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for(int left = 0;left < array.length - 1;left += 2*k){
            reverse(array, left, left + 2 * k, k);
        }
        return new String(array);
    }
}
// @lc code=end

