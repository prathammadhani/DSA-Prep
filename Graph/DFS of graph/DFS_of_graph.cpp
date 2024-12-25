// Problem Name: DFS of graph
// Problem Link: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {
  public:
    // Function to return a list containing the DFS traversal of the graph.
    vector<int> ans;
    void dfs(int node,vector<vector<int>>& adj,vector<int>& vis){
        vis[node] = 1;
        ans.push_back(node);
        for(int it : adj[node]){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }
    
    vector<int> dfsOfGraph(vector<vector<int>>& adj) {
        int V = adj.size();
        vector<int> vis(V,0);
        dfs(0,adj,vis);
        return ans;
    }
};