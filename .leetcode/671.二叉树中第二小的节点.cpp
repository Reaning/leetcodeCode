/*
 * @lc app=leetcode.cn id=671 lang=cpp
 *
 * [671] 二叉树中第二小的节点
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
//  struct TreeNode {
//       int val;
//       TreeNode *left;
//       TreeNode *right;
//       TreeNode() : val(0), left(nullptr), right(nullptr) {}
//       TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };


class Solution {
public:
    int first = INT_MIN,second = INT_MIN;
    void dfs(TreeNode* head){
        if(!head)return;
        if(-head->val > first){
            if(first != INT_MIN)second = -first;
            else second = INT_MIN;
            first = -head->val;
        }else if(-head -> val < first&&-head->val > second){
            second = -head->val;
        }
        dfs(head->left);
        dfs(head->right);
    }
    int findSecondMinimumValue(TreeNode* root) {
        // int first = INT_MAX,second = INT_MAX;
        dfs(root); 
        if(second != INT_MIN)return -second;
        return -1;
    }
};
// @lc code=end

