import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    TreeNode pre;
    boolean left = false;
    public void dfs(TreeNode root, int val){
        if(root == null){
            if(pre != null){
                if(left) pre.left = new TreeNode(val);
                else pre.right = new TreeNode(val);
            }
            return;
        }
        pre = root;
        if(root.val > val){
            left = true;
            dfs(root.left, val);
        }
        else {
            left = false;
            dfs(root.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        dfs(root, val);
        return root;
    }
}
// @lc code=end

