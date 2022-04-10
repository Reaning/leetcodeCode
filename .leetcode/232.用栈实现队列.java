import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    private Deque<Integer> queue1;
    private Deque<Integer> queue2;

    public MyQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.push(x);
    }
    
    public int pop() {
        if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                queue2.push(queue1.pop());
            }
        }
        return queue2.pop();
    }
    
    public int peek() {
        int temp = this.pop();
        queue2.push(temp);
        return temp;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

