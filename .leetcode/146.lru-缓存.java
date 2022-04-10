import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size;
    Map<Integer,Node> mp = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        String s = "123";
    }
    
    public int get(int key) {
        Node node = mp.get(key);
        if(node == null)return -1;
        moveToHead(node);
        Node n = head.next;
        while(n != null){
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println("");
        
        return node.value;
    }
    
    public void put(int key, int value) {
        // Node n = head.next;
        // while(n != null){
        //     System.out.println(n.value);
        //     n = n.next;
        // }
        System.out.println("");
        Node temp = mp.get(key);
        if(temp == null){
            Node newNode = new Node(key,value);
            newNode.next = head.next;
            newNode.prev = head;
            head.next.prev = newNode;
            head.next = newNode;
            size++;
            mp.put(key, newNode);
            System.out.println(size + " " + capacity);
            if(size > capacity){
                removeNode(tail.prev);
                size--;
            }
        }else{
            temp.value = value;
        }
        // System.out.println(value);
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node){
        removeNode(node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    // Map<Integer,Integer>mp = new HashMap<>();
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

