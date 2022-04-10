import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    public List<List<Integer>> ans;
    public List<Integer> temp;
    void dfs(TreeNode root,int targetSum,int sum){
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                List<Integer> list = new LinkedList<>();
                list.addAll(temp);
                ans.add(list);
            }
            temp.remove(temp.size() - 1);
            return;
        }
        if(root.left != null){
            dfs(root.left, targetSum, sum);
        }
        if(root.right != null){
            dfs(root.right, targetSum, sum);
        }
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new LinkedList<>();
        temp = new LinkedList<>();        
        if(root == null)return ans;
        dfs(root, targetSum, 0);
        return ans;
    }
}
// @lc code=end

