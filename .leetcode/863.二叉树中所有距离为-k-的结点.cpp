/*
 * @lc app=leetcode.cn id=863 lang=cpp
 *
 * [863] 二叉树中所有距离为 K 的结点
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
//  struct TreeNode {
//      int val;
//      TreeNode *left;
//      TreeNode *right;
//     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
//  };

class Solution {
public:
    vector<int>ans;
    void getans(TreeNode* root,int target,int depth){
        queue<TreeNode*>q;
        q.push(root);
        while(q.size()){
            int n = q.size();
            for(int i = 0; i < n;i++){
                TreeNode* temp = q.front();
                q.pop();
                if(depth == target)ans.push_back(temp->val);
                else{
                    if(temp->left)q.push(temp->left);
                    if(temp->right)q.push(temp->right);
                }
            }
            if(depth == target)return;
            depth++;
        }
    }
    int dfs(TreeNode* root,TreeNode* target,int K){
        if(root == target)return 1;
        if(root == NULL)return 0;
        if(root->left == NULL && root->right == NULL && root != target)return 0;
        int left = dfs(root->left,target,K);
        int right = dfs(root->right,target,K);
        if(left == 0 && right == 0)return 0;
        if(left == -100 || right == -100)return -100;
        if(left){
            if(K - left == 0){
                ans.push_back(root->val);
                return -100;
            }
            else if(root->right){
                if(K - left == 1)ans.push_back(root->right->val);
                else
                getans(root->right,K - left,1);
            }
            return left + 1;
        }else{
            if( K - right == 0){
                ans.push_back(root->val);
                return -100;
            }
            else if(root->left){
                if(K - right == 1)ans.push_back(root->left->val);
                else
                getans(root->left,K - right,1);
            }
            return right + 1;
        }
        return 0;

    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        if(k == 0){
            ans.push_back(target->val);
            return ans;
        }
        getans(target,k,0);
        dfs(root,target,k);
        return ans;
    }
};
// @lc code=end

