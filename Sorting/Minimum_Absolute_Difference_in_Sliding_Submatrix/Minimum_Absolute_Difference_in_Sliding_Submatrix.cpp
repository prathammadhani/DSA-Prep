//Problem Name: Minimum Absolute Difference in Sliding Submatrix
//Problem Link: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/

class Solution {
public:
    vector<vector<int>> minAbsDiff(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> ans(m - k + 1, vector<int>(n - k + 1));
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                vector<int> temp;
                for (int o = i; o < i + k; o++) {
                    for (int p = j; p < j + k; p++) {
                        temp.push_back(grid[o][p]);
                    }
                }
                sort(temp.begin(), temp.end());
                int mn = INT_MAX;
                for (int o = 0; o < temp.size() - 1; o++) {
                    if (temp[o + 1] == temp[o])
                        continue;
                    mn = min(mn, abs(temp[o + 1] - temp[o]));
                }
                if (mn != INT_MAX)
                    ans[i][j] = mn;
            }
        }
        return ans;
    }
};