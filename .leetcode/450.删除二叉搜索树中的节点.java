import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    boolean left;
    TreeNode head;
    public void dfs(TreeNode root, int key){
        if(root == null)return;
        if(root.val == key){
            if(pre == null){
                // 处理头结点的问题
                TreeNode temp = head.left;
                if(root.right == null){
                    head = root.left;
                    return;
                }else{
                    root = root.right;
                    head = root;
                    pre = root;
                    while(root.left != null){
                        pre = root;
                        root = root.left;
                    }
                    pre.left = temp;
                    return;
                }
            }else{
                // 非头结点
                TreeNode temp = root.left;
                if(root.right == null){
                    if(left)pre.left = temp;
                    else pre.right = temp;
                }
                else{
                    if(left)pre.left = root.right;
                    else pre.right = root.right;
                    root = root.right;
                    while(root.left != null){
                        root = root.left;
                    }
                    root.left = temp;
                }
            }
            return;
        }
        pre = root;
        if(root.val > key) {
            left = true;
            dfs(root.left, key);
        }
        else {
            left = false;
            dfs(root.right, key);
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        head = root;
        dfs(root, key);
        return head;        
    }
}
// @lc code=end

