// Problem Name: Topological Sort Algorithm
// Problem Link: https://www.geeksforgeeks.org/problems/topological-sort/1

// DFS Approach
class Solution {
  public:
    
    void dfs(int node, vector<vector<int>>& adj, vector<int>& vis, stack<int>& st) {
        vis[node] = 1;
        for (auto it : adj[node]) {
            if (!vis[it]) {
                dfs(it, adj, vis, st);
            }
        }
        st.push(node);
    }
    
    vector<int> topologicalSort(vector<vector<int>>& adj) {
        int V = adj.size();
        vector<int> vis(V,0);
        stack<int> st;
        for (int i = 0;i < V;i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }
        vector<int> ans;
        while (!st.empty()) {
            ans.push_back(st.top());
            st.pop();
        }
        return ans;
    }
};

// Kahn's Algorithm (Topological Sort - BFS Approach)
class Solution {
  public:
    
    vector<int> topologicalSort(vector<vector<int>>& adj) {
        int V = adj.size();
        vector<int> inDegree(V,0);
        for (auto it : adj) {
            for (auto it2 : it) {
                inDegree[it2]++;
            }
        }
        queue<int> q;
        vector<int> ans;
        for(int i = 0;i<V;i++){
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            ans.push_back(node);
            for (auto it : adj[node]) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.push(it);
                }
            }
        }
        return ans;
    }
};