/*
 * @lc app=leetcode.cn id=993 lang=cpp
 *
 * [993] 二叉树的堂兄弟节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<pair<TreeNode*,int>>stk;
        stk.push(make_pair(root,root->val));
        while(!stk.empty()){
            int length = stk.size();
            int xf=0,yf=0;
            int xfa,yfa;
            for(int i = 0; i < length;i++){
                if(stk.front().first->left)stk.push(make_pair(stk.front().first->left,stk.front().first->val));
                if(stk.front().first->right)stk.push(make_pair(stk.front().first->right,stk.front().first->val));
                if(stk.front().first->val==x){xf++;xfa=stk.front().second;}
                if(stk.front().first->val==y){yf++;yfa = stk.front().second;}
                stk.pop();
            }
            if((xf&&yf)&&(xfa!=yfa))return true;
        }
        return false;
    }
};
// @lc code=end

