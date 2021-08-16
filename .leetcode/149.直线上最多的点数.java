/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        String ans = "";
        int left = 0;
        while(left < n){
            int i = left;
            while(left + 1 < n && s.charAt(left) == s.charAt(left + 1)){
                left++;
            }
            int length = left - i + 1;
            if(length >= 2){
                ans = ans + s.charAt(left) + s.charAt(left);
            }else if(length == 1){
                ans = ans + s.charAt(left);
            }
            left++;
        }
        return ans;
    }
}
// class Solution {
//     public int[][] direction = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
//     public Integer judge(char[][]board, int index, int rMove,int cMove,int m,int n){ 
//         int r = rMove + direction[index][0],c = cMove + direction[index][1];
//         if(r == -1||c == -1||c == n||c == m||board[rMove][cMove] == board[r][c])return 1;
//         char cl = board[r][c];
//         if(cl == '.')return 1;
//         while(r >=0 && c>=0 && r<m && c < n && board[r][c] == cl){
//             r = r + direction[index][0];
//             c = c + direction[index][1];
//         }
//         if(r < 0 || r == m || c == n ||c == -1)return 1;
//         if(board[r][c] == board[rMove][cMove]){
//             return 2;
//         }
//         return 1;
//     }
//     public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
//         int m = board.length,n = board[0].length;
//         board[rMove][cMove] = color;
//         int[] judgeblock = new int[8];
//         for(int i = 0;i < direction.length;i++){
//             int r = rMove + direction[i][0],c = cMove + direction[i][1];
//             if(r != -1 && c != -1 && r != m && c != n && board[r][c] != ','){
//                 judgeblock[i] = judge(board, i, rMove, cMove,m,n);
//                 System.out.println(judgeblock[i]);
//                 if(judgeblock[i] == 2){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
// }class Solution {
//     public int 
//     public int maxPoints(int[][] points) {
        
//     }
// }
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        List<Integer> d = new ArrayList<>();
        for(int i = 0;i < n;i++){
            
        }
    }
}
// @lc code=end

