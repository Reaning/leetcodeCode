import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long pre = Long.MIN_VALUE;
    public boolean dfs(TreeNode root){
        if(root == null)return true;
        if(!dfs(root.left))return false;
        if(pre != Long.MIN_VALUE){
            if(pre >= root.val)return false;
        }
        pre = root.val;
        if(!dfs(root.right))return false;
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
}
// @lc code=end

