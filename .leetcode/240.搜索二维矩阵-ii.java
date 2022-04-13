/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        int x = 0,y = n - 1;
        while(true){
            if(x < 0 || x >= m || y < 0 || y >= n){
                return false;
            }
            if(matrix[x][y] == target){
                return true;
            }
            if(matrix[x][y] > target){
                y--;
            }else{
                x++;
            }
        }
        // return false;
    }
}
// @lc code=end

