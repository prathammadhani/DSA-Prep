//Problem Name: Minimum Absolute Difference in Sliding Submatrix
//Problem Link: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int o = i; o < i + k; o++) {
                    for (int p = j; p < j + k; p++) {
                        temp.add(grid[o][p]);
                    }
                }
                int mn = Integer.MAX_VALUE;
                Collections.sort(temp);
                for (int o = 0; o < temp.size() - 1; o++) {
                    if (temp.get(o + 1).equals(temp.get(o)))
                        continue;
                    mn = Math.min(mn, temp.get(o + 1) - temp.get(o));
                }
                if (mn != Integer.MAX_VALUE)
                    ans[i][j] = mn;
            }
        }
        return ans;
    }
}