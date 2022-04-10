/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode subTree(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright){
        if(pleft > pright || ileft > iright)return null;
        int val = preorder[pleft];
        TreeNode root = new TreeNode(val);
        int mid = ileft;
        while(mid < iright && inorder[mid] != val)mid++;
        root.left = subTree(preorder, inorder, pleft + 1, pleft + mid - ileft, ileft, mid - 1);
        root.right = subTree(preorder, inorder, pleft + mid - ileft + 1, pright, mid + 1, iright);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        int n = preorder.length - 1;
        return subTree(preorder, inorder, 0, n, 0, n);
    }
}
// @lc code=end

