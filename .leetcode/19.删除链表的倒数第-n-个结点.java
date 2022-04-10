import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return head;
        ListNode vhead = new ListNode(0,head);
        ListNode slow = vhead;
        ListNode fast = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return vhead.next;
    }
}
// @lc code=end

