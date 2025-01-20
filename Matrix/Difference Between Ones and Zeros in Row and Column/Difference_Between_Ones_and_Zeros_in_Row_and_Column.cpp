// Problem Name: Difference Between Ones and Zeros in Row and Column
// Problem Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/

class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> onesRow(m), onesCol(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }
        vector<vector<int>> ans(m, vector<int>(n));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (2 * onesRow[i] - m) + (2 * onesCol[j] - n);
            }
        }
        return ans;
    }
};