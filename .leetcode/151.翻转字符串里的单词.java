import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public void reverse(Character[] array,int left,int right){
        while(left < right){
            char tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }
    public String reverseWords(String s) {
        int n = s.length();
        int left = 0,right = n;
        while(left < n && s.charAt(left) == ' '){
            left++;
        }
        while(right > 0 && s.charAt(right - 1) == ' '){
            right--;
        }
        if(left >= n || right <= 0)return "";
        String temp = s.substring(left, right);
        List<Character>list = new ArrayList<>();
        // System.out.println(temp);
        n = temp.length();
        for(int i = 0;i < n;i++){
            if(temp.charAt(i) == ' '){
                while(i < n && temp.charAt(i) == ' ' && temp.charAt(i) == temp.charAt(i - 1)){
                    i++;
                }
            }
            if(i < n){
                char tmp = temp.charAt(i);
                list.add(tmp);
            }
        }
        Character[] array = list.toArray(new Character[0]);
        System.out.println(Arrays.toString(array));
        n = array.length;
        reverse(array,0,n - 1);
        left = 0;
        for(int i = 0; i < n;i++){
            if(array[i] == ' '){
                reverse(array, left, i - 1);
                left = i + 1;
            }    
        }
        reverse(array, left, n - 1);
        char[] a = new char[n];
        for(int i = 0; i < n;i++){
            a[i] = array[i];
        }
        return new String(a);
    }
}
// @lc code=end

