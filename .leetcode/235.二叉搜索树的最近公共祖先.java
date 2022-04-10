/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode dfs(TreeNode root,TreeNode left,TreeNode right){
        if(root == null)return root;
        if(root.val > left.val && root.val < right.val)return root;
        if(root.val > right.val)return dfs(root.left, left, right);
        return dfs(root.right, left, right);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = p.val > q.val ? q : p;
        TreeNode right = p.val > q.val ? p : q;
        return dfs(root, left, right);
    }
}
// @lc code=end

