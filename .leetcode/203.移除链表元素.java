/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// // @lc code=start
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return head;
        ListNode vhead = new ListNode(0,head);
        head = vhead;
        while(head != null && head.next!= null){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return vhead.next;
    }
}
// @lc code=end

