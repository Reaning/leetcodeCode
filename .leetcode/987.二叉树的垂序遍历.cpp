/*
 * @lc app=leetcode.cn id=987 lang=cpp
 *
 * [987] 二叉树的垂序遍历
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
    map<int,vector<pair<int,int>>>mp;
    static bool cmp(pair<int,int>a,pair<int,int>b){
        if(a.first != b.first)return a.first < b.first;
        return a.second < b.second;
    }
    void dfs(TreeNode* root,int r,int c){
        mp[c].emplace_back(r,root->val);
        if(root->left)dfs(root->left,r + 1,c - 1);
        if(root->right)dfs(root->right,r + 1,c + 1);
    }
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>>ans;
        dfs(root,0,0);
        for(auto it = mp.begin();it != mp.end();it++){
            sort(it->second.begin(),it->second.end(),cmp);
            vector<int>temp;
            for(auto i : it->second){
                temp.push_back(i.second);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};
// @lc code=end

