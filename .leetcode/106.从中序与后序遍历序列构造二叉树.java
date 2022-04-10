import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode subTree(int[] inorder,int[] postorder,int ileft,int iright,int pleft,int pright){
        if(ileft > iright || pleft > pright)return null;
        int val = postorder[pright];
        TreeNode root = new TreeNode(val);
        LinkedList<String> a = new LinkedList<>();
        ArrayList<String> b = new ArrayList<>();
        b.iterator();
        a.iterator();
        int mid = ileft;
        while(mid < iright && inorder[mid] != val)mid++;
        root.left = subTree(inorder, postorder, ileft, mid - 1, pleft, pleft + mid - ileft - 1);
        root.right = subTree(inorder, postorder, mid + 1, iright, pleft + mid - ileft, pright - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)return null;
        return subTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}
// @lc code=end

