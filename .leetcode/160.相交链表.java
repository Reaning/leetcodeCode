import java.util.List;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        do{
            if(fast == null || fast.next == null){
                temp.next = null;
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }while(slow != fast);
        while(headB != slow){
            headB = headB.next;
            slow = slow.next;
        }
        temp.next = null;
        return headB;
    }
}
// @lc code=end

