import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public int isBalancedNode(TreeNode root){
        if(root == null)return 0;
        int left = isBalancedNode(root.left);
        int right = isBalancedNode(root.right);
        if(left == -1 || right == -1)return -1;
        int temp = Math.abs(left - right);
        if(temp <= 1){
            return Math.max(left, right) + 1;
        }
        return -1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        return isBalancedNode(root) == -1 ? false:true;
    }
}
// @lc code=end

