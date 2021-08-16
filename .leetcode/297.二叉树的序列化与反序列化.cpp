/*
 * @lc app=leetcode.cn id=297 lang=cpp
 *
 * [297] 二叉树的序列化与反序列化
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start

// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
// };

class Codec {
public:
    TreeNode* temp;
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        temp = root;
        cout<<2<<endl;
        return "a";
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        // TreeNode* a = temp;
        cout<<1<<endl;
       return NULL; 
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));
// @lc code=end

