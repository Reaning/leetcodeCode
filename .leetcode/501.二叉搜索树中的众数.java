import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    public List<Integer> temp;
    public int maxCount;
    public int count;
    public int pre;
    public void dfs(TreeNode root){
        if(root.left != null) dfs(root.left);
        if(pre == -100001){
            pre = root.val;
            count = 1;
            maxCount = 1;
            temp.add(pre);
        }
        else{
            if(root.val == pre){
                count++;
            }else{
                count = 1;
            }
            if(count > maxCount){
                temp.clear();
                temp.add(root.val);
                maxCount = count;
            }else if(count == maxCount){
                temp.add(root.val);
            }
            pre = root.val;
        }   
        if(root.right != null) dfs(root.right);
    }
    public int[] findMode(TreeNode root) {
        pre = -100001;
        temp = new LinkedList<>();
        dfs(root);
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

