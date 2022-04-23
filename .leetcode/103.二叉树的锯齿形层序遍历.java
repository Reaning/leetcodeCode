import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if(root == null)return ans;
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            // List<Integer> temp = new ArrayList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = 0;i < n;i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(level % 2 == 1){
                    temp.addFirst(node.val);
                }else{
                    temp.add(node.val);
                }
            }
            level++;
            ans.add(temp);
        }
        return ans;
    }
}
// @lc code=end

