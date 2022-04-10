/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    void dfs(TreeNode root){
        if(root == null)return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        dfs(root.left);
        dfs(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return root;
        dfs(root);
        return root;
    }
}
// @lc code=end

