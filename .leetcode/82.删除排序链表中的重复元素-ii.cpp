/*
 * @lc app=leetcode.cn id=82 lang=cpp
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
#include<bits/stdc++.h>
using namespace std;

// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//     ListNode(int x, ListNode *next) : val(x), next(next) {}
// };
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head)return head;
        ListNode* pre = NULL;
        ListNode* cur = head;
        ListNode* ans = NULL;
        // while(!pre && pre!=pre->next){
        //     pre = pre->next;
        // }
        // if(!pre || !pre->next)return NULL;
        // pre = pre->next;
        while(cur!=NULL){
            if(cur->next == NULL||cur->val != cur->next->val){
                if(pre != NULL)pre->next = cur;
                else ans = cur;
                pre = cur;
            }else{
                while(cur->next&& cur->val == cur->next->val){
                    cur = cur->next;
                }
            }
            cur = cur->next;
        }
        return ans; 
    }
};
// @lc code=end

