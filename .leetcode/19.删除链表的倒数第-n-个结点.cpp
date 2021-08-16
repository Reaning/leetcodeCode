/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] 删除链表的倒数第 N 个结点
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head)return head;
        if(!head->next||!head)return NULL;
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* pre = head;
        for(int i = 0;i < n;i++){
            fast = fast->next;
        }
        while(fast){
            pre = slow;
            fast = fast->next;
            slow = slow->next;
        }
        if(slow == pre) head = slow->next;
        else pre->next = pre->next->next;
        return head;
    }
};
// @lc code=end

