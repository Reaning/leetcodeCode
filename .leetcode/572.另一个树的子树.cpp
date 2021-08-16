/*
 * @lc app=leetcode.cn id=572 lang=cpp
 *
 * [572] 另一个树的子树
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start

// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };

class Solution {
public:
    bool isSame(TreeNode* root,TreeNode* subroot){
        if(!root && !subroot)return true;
        if(!root || !subroot)return false;
        if(root->val == subroot->val)return isSame(root->left,subroot->left)&&isSame(root->right,subroot->right);
        return false;
    }
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        queue<TreeNode*>q;
        q.push(root);
        while(q.size()){
            int n = q.size();
            for(int i = 0; i < n;i++){
                auto tmp = q.front();
                q.pop();
                if(tmp->left)q.push(tmp->left);
                if(tmp->right)q.push(tmp->right);
                if(tmp->val == subRoot->val && isSame(tmp,subRoot))return true;
            }
        }
        return false;
    }
};
// @lc code=end

