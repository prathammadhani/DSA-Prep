// Problem Name: Redundant Connection
// Problem Link: https://leetcode.com/problems/redundant-connection/ 

class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adj;
        unordered_set<int> st;
        for (auto& it : edges) {
            int u = it[0];
            int v = it[1];
            if (dfs(st, u, v, adj))
                return it;
            st.clear();
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        return {};
    }

    bool dfs(unordered_set<int>& st, int src, int dest,
             unordered_map<int, vector<int>>& adj) {
        if (src == dest)
            return true;
        st.insert(src);
        for (auto& it : adj[src]) {
            if (st.find(it) == st.end()) {
                if (dfs(st, it, dest, adj))
                    return true;
            }
        }
        return false;
    }
};