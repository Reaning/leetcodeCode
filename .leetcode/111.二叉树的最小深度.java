/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 && right == 0)return 1;
        if(left == 0)return right + 1;
        if(right == 0)return left + 1;
        return 1 + Math.min(left, right);
    }
}
// @lc code=end

