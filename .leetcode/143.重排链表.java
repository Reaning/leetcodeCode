import java.util.List;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reverse(ListNode pre){
        ListNode node = pre.next;
        ListNode head = pre.next.next;
        node.next = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = node;
            node = temp;
        }
        pre.next = node;
    }
    public void sum(ListNode left,ListNode right){
        while(right != null){
            ListNode temp = left.next;
            left.next = right;
            right = right.next;
            left.next.next = temp;
            left = temp;
        }
    }
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == slow || (fast == slow.next && fast == null))return;
        reverse(slow);
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        sum(left, right);
        // return left;
    }
}
// @lc code=end

