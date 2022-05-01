import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import javax.xml.validation.Validator;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

// class LRUCache {

//     class Node{
//         Node prev;
//         Node next;
//         int val;
//         int key;
//         Node(){}
//         Node(int key,int val){
//             this.key = key;
//             this.val = val;
//         }
//         Node(Node prev,Node next,int key,int val){
//             this.key = key;
//             this.prev = prev;
//             this.val = val;
//             this.next = next;
//         }
//     }

//     private int capacity;
//     private Map<Integer,Node> mp = new HashMap<>();
//     private int n;
//     private Node head;
//     private Node tail;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         head = new Node(null,null,0,0);
//         tail = new Node(head,null,0,0);
//         head.next = tail;
//         n = 0;
//     }
    
//     public int get(int key) {
//         Node node = mp.get(key);
//         if(node == null)return -1;
//         outPut();
//         moveFirst(node);
//         return node.val;
//     }
    
//     public void put(int key, int value) {
//         Node curNode = mp.get(key);
//         if(curNode != null){
//             curNode.val = value;
//             // System.out.println(curNode.val);
//             moveFirst(curNode);
//             return;
//         }
//         n++;
//         // System.out.println(n);
//         // outPut();
//         addFirst(key,value);
//         if(n > capacity){
//             deleteLast();
//         }
//         // outPut();
//     }

//     public void addFirst(int key,int value){
//         Node node = new Node(key,value);
//         mp.put(key, node);
//         tail.prev.next = node;
//         node.next = tail;
//         node.prev = tail.prev;
//         tail.prev = node;
//         if(n != 1){
//             moveFirst(node);
//         }
//     }
    
//     public void moveFirst(Node node){
//         if(n != 1 && node.prev != head){
//         Node temp = head.next;
//         node.prev.next = node.next;
//         node.next.prev = node.prev;
//         node.prev = head;
//         head.next = node;
//         node.next = temp;
//         temp.prev = node;
//         }
//     }

//     public void deleteLast(){
//         int value = tail.prev.key;
//         // System.out.println(value);
//         mp.remove(value);
//         tail.prev = tail.prev.prev;
//         tail.prev.next = tail;
//         n--;
//     }

//     public void outPut(){
//         Node n = head.next;
//         while(n != tail){
//             System.out.print(n.val);
//             n = n.next;
//         }
//         System.out.println();
//     }

// }
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

