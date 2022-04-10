import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public boolean isNumber(String temp){
        return !(temp.equals("*") || temp.equals("+") || temp.equals("-") || temp.equals("/"));
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer>st = new LinkedList<>();
        for(String token:tokens){
            if(isNumber(token)){
                st.push(Integer.valueOf(token));
            }else{
                int right = st.pop();
                int left = st.pop();
                if(token.equals("+"))st.push(left + right);
                else if(token.equals("*"))st.push(left * right);
                else if(token.equals("-"))st.push(left - right);
                else if(token.equals("/"))st.push(left / right);
            }
        }
        return st.pop();
    }
}
// @lc code=end

