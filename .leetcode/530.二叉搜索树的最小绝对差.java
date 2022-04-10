/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    public int ans;
    public int pre;
    public void dfs(TreeNode root){
        if(root.left != null)dfs(root.left);
        if(pre == -1)pre = root.val;
        else {
            ans = Math.min(ans, Math.abs(root.val - pre));
            pre = root.val;
        }
        if(root.right != null)dfs(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
}
// @lc code=end

