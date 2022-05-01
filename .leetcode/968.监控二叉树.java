/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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
    public int res = 0;
    public int dfs(TreeNode root){
        //2:已覆盖 1:摄像头 0:未覆盖
        if(root == null)return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //如果两个子节点均已覆盖，则返回未覆盖
        if(left == 2 && right == 2){
            return 0;
        }
        // 0 1 0 2
        //如果任一子节点没有摄像头，当前节点一定要有摄像头
        if(left == 0 || right == 0){
            res++;
            return 1;
        }
        //1 2
        //如果任一子节点均有摄像头
        if(left == 1 || right == 1){
            return 2;
        }
        return 1;
    }
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == 0){
            res++;
        }
        return res;
    }
}
// @lc code=end

