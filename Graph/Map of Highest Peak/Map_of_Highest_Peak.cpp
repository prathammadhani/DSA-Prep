// Problem Name: Map of Highest Peak
// Problem Link: https://leetcode.com/problems/map-of-highest-peak/

class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        int m = isWater.size();
        int n = isWater[0].size();
        vector<vector<int>> ans(m, vector<int>(n, -1));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.push({i, j});
                    ans[i][j] = 0;
                }
            }
        }

        int dx[4] = {-1, 0, 1, 0};
        int dy[4] = {0, 1, 0, -1};
        while (!q.empty()) {
            int currRow = q.front().first;
            int currCol = q.front().second;
            q.pop();

            for (int k = 0; k < 4; k++) {
                int newRow = currRow + dx[k];
                int newCol = currCol + dy[k];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    ans[newRow][newCol] == -1) {
                    ans[newRow][newCol] = 1 + ans[currRow][currCol];
                    q.push({newRow, newCol});
                }
            }
        }
        return ans;
    }
};