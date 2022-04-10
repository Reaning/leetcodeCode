import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    boolean dfs(TreeNode root,int temp,int targetSum){
        temp += root.val;
        if(root.left == null && root.right == null){
            return temp == targetSum;
        }
        if(root.left != null && dfs(root.left, temp, targetSum))return true;
        if(root.right != null && dfs(root.right, temp, targetSum))return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        return dfs(root, 0, targetSum);
    }
}
// @lc code=end

