import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<TreeNode>st = new LinkedList();
        while(root != null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                TreeNode node = st.peek();
                st.pop();
                ans.add(node.val);
                root = node.right;
            }
        }
        return ans;
    }
}
// @lc code=end

