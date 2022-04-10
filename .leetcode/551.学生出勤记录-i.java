import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
// class Solution {
//     public boolean checkRecord(String s) {
//         int n = s.length();
//         int m = 0;
//         for(int i = 0;i < n;i++){
//             if(s.charAt(i) == 'A')m++;
//             if(m >= 2)return false;
//             if(s.charAt(i) == 'L'){
//                 int temp = 1;
//                 while(i + 1 < n && s.charAt(i + 1) == 'L'){
//                     i++;
//                     temp++;
//                 }
//                 if(temp >= 3)return false;
//             } 
//         }
//         return true;
//     }
// }
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        int level = 1;
        while(q.size() > 0){
            LinkedList<Integer> temp = new LinkedList<>();
            // LinkedList<Integer> tmp = new LinkedList<>();
            int n = q.size();
            for(int i = 0;i < n;i++){
                TreeNode t = q.poll();
                if(level % 2 == 0)temp.addLast(t);
                else temp.addFirst(t);
                if(t.left != null)q.add(t.left);
                if(t.right != null)q.add(t.right);
            }
            ans.add(temp);
            level++;
        }
        return ans;
    }
}
// @lc code=end

