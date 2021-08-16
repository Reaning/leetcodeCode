/*
 * @lc app=leetcode.cn id=138 lang=cpp
 *
 * [138] 复制带随机指针的链表
 */

#include<bits/stdc++.h>
using namespace std;

// class Node {
// public:
//     int val;
//     Node* next;
//     Node* random;
    
//     Node(int _val) {
//         val = _val;
//         next = NULL;
//         random = NULL;
//     }
// };


class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head)return NULL;
        Node* pre = head;
        Node* node = new Node(head->val);
        node->random = pre->random;
        unordered_map<Node*,Node*>mp;
        // int cur = 0;
        mp.insert(make_pair(head,node));
        pre = pre->next;
        Node* copyhead = node;
        while(pre){
            Node* temp = new Node(pre->val);
            node->next = temp;
            mp.insert(make_pair(pre,temp));
            temp->random = pre->random;
            node = temp;
            pre = pre->next;
        }
        node = copyhead;
        Node* temp;
        while(node){
            temp = node->random;
            if(temp)
                node->random = mp[node->random];
            node = node->next;
        }
        
        return copyhead;
    }
};
// @lc code=end

