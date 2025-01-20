// Problem Name: Difference Between Ones and Zeros in Row and Column
// Problem Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (2 * onesRow[i] - m) + (2 * onesCol[j] - n);
            }
        }
        return ans;
    }
}