/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    // public ListNode merge(ListNode h1,ListNode h2){
    //     if(h1 == null)return h2;
    //     if(h2 == null)return h1;
    //     ListNode head = new ListNode();
    //     if(h1.val > h2.val){
    //         head = h2;
    //         head.next = merge(h1, h2.next);
    //     }else{
    //         head = h1;
    //         head.next = merge(h1.next, h2);
    //     }
    //     return head;
    // }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(fast));
    }
}
// @lc code=end

