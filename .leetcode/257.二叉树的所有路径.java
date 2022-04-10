import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String>ans = new LinkedList<>();
    public void dfs(TreeNode root,String path){
        StringBuffer sb = new StringBuffer(path);
        sb.append(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            ans.add(sb.toString());
            return;
        }
        sb.append("->");
        path = sb.toString();
        if(root.left != null)dfs(root.left,path);
        if(root.right != null)dfs(root.right, path);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }
}
// @lc code=end

