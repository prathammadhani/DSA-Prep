// Problem Name: First Completely Painted Row or Column
// Problem Link: https://leetcode.com/problems/first-completely-painted-row-or-column/description/

class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        vector<int> row(m);
        vector<int> col(n);
        unordered_map<int,pair<int,int>> mp;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                mp[mat[i][j]] = {i,j};
            }
        }

        for(int i = 0;i<arr.size();i++) {
            pair<int,int> curr = mp[arr[i]];
            row[curr.first]++;
            col[curr.second]++;
            if(row[curr.first] == n || col[curr.second] == m) return i;
        }
        return -1;
    }
};