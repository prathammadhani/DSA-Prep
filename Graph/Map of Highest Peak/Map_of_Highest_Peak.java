// Problem Name: Map of Highest Peak
// Problem Link: https://leetcode.com/problems/map-of-highest-peak/

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = -1;
            }
        }
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[] { i, j });
                    ans[i][j] = 0;
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int k = 0; k < 4; k++) {
                int newRow = currRow + dx[k];
                int newCol = currCol + dy[k];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && ans[newRow][newCol] == -1) {
                    ans[newRow][newCol] = 1 + ans[currRow][currCol];
                    q.add(new int[] { newRow, newCol });
                }
            }
        }
        return ans;
    }
}