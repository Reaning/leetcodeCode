import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<TreeNode>st = new LinkedList<>();
        st.push(root);
        st.push(null);
        while(!st.isEmpty()){
            root = st.pop();
            if(root == null){
                root = st.pop();
                st.push(root);
                if(root.right != null){
                    st.push(root.right);
                    st.push(null);
                }
                if(root.left != null){
                    st.push(root.left);
                    st.push(null);
                }
            }else{
                ans.add(root.val);
            }
        }
        return ans;
    }
}
// @lc code=end

