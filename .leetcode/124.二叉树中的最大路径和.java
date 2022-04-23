import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int ans = Integer.MIN_VALUE;
    public int getNum(TreeNode root){
        if(root == null)return 0;
        int left = getNum(root.left);
        int right = getNum(root.right);
        int res = Math.max(left + root.val, Math.max(root.val, right + root.val));
        ans = Math.max(res,Math.max(ans, left + right + root.val));
        return res;
    }
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        getNum(root);
        return ans;
    }
}
// @lc code=end

