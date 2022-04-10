import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.peek();
            st.pop();
            ans.add(node.val);
            if(node.right != null)st.push(node.right);
            if(node.left != null)st.push(node.left);
        }
        return ans;
    }
}
// @lc code=end

