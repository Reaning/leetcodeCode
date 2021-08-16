/*
 * @lc app=leetcode.cn id=117 lang=cpp
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
// class Node {
// public:
//     int val;
//     Node* left;
//     Node* right;
//     Node* next;

//     Node() : val(0), left(NULL), right(NULL), next(NULL) {}

//     Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

//     Node(int _val, Node* _left, Node* _right, Node* _next)
//         : val(_val), left(_left), right(_right), next(_next) {}
// };

class Solution {
public:
    Node* connect(Node* root) {
        if(!root)return root;
        queue<Node*>q;
        q.push(root);
        while(q.size()){
            int n = q.size();
            for(int i = 0;i < n;i++){
                auto it = q.front();
                q.pop();
                if(it->left)q.push(it->left);
                if(it->right)q.push(it->right);
                if(i < n - 1)it->next = q.front();
            }
        }   
        return root;
    }
};
// @lc code=end

