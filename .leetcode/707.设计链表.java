/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class ListNode{
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    private ListNode head;
    int num;

    public MyLinkedList() {
        head = new ListNode();
        num = 0;
    }
    
    public int get(int index) {
        if(index >= num || index < 0){
            return -1;
        }
        ListNode cur = head.next;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val,head.next);
        head.next = node;    
        num++;
    }
    
    public void addAtTail(int val) {
        ListNode cur = head.next;
        if(cur == null){
            addAtHead(val);
            return;
        }
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        num++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index <= 0)addAtHead(val);
        else if(index == num)addAtTail(val);
        else if(index > num)return;
        else{
            ListNode cur = head.next;
            index--;
            while(index > 0){
                cur = cur.next;
                index--;
            }
            cur.next = new ListNode(val,cur.next);
            num++;
        }
    }
    
    public void deleteAtIndex(int index) {
        ListNode cur = head;
        if(index < 0 || index >= num)return;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        num--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

