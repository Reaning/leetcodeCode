import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int left = 0,right = n - 1;
        do{
            while(left < n && !check(arr[left]))left++;
            while(right >= 0 && !check(arr[right]))right--;
            if(left > right)break;
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }while(left < right);
        return new String(arr);
    }
    public boolean check(char ch){
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
// @lc code=end

