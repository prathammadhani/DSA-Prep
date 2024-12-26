// Problem Name: LC - 733. Flood Fill/Flood fill Algorithm
// Problem Link: https://leetcode.com/problems/flood-fill/, https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1

// BFS Approach
class Solution {
public:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    void bfs(int i, int j, vector<vector<int>>& image, vector<vector<int>>& ans,
             int oldColor, int color) {
        queue<pair<int, int>> q;
        q.push({i, j});
        ans[i][j] = color;
        while (!q.empty()) {
            auto node = q.front();
            q.pop();
            int x = node.first;
            int y = node.second;
            for (int k = 0; k < 4; k++) {
                int row = x + dx[k];
                int col = y + dy[k];
                if (row >= 0 && row < image.size() && col >= 0 &&
                    col < image[0].size() && image[row][col] == oldColor &&
                    ans[row][col] != color) {
                    ans[row][col] = color;
                    q.push({row, col});
                }
            }
        }
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc,
                                  int color) {
        int m = image.size();
        int n = image[0].size();
        int oldColor = image[sr][sc];
        vector<vector<int>> ans = image;
        bfs(sr, sc, image, ans, oldColor, color);
        return ans;
    }
};

// DFS Approach
class Solution {
public:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    void dfs(int i, int j, vector<vector<int>>& image, vector<vector<int>>& ans,
             int oldColor, int color) {
        ans[i][j] = color;
        for (int k = 0; k < 4; k++) {
            int row = i + dx[k];
            int col = j + dy[k];
            if (row >= 0 && row < image.size() && col >= 0 &&
                col < image[0].size() && image[row][col] == oldColor &&
                ans[row][col] != color) {
                dfs(row, col, image, ans, oldColor, color);
            }
        }
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc,
                                  int color) {
        int m = image.size();
        int n = image[0].size();
        int oldColor = image[sr][sc];
        vector<vector<int>> ans = image;
        dfs(sr, sc, image, ans, oldColor, color);
        return ans;
    }
};