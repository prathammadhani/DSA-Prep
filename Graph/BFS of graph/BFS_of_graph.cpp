// Problem Name: BFS of graph
// Problem Link: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
  public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfs(vector<vector<int>>& adj,int V){
        vector<int> vis(V,0), ans;
        queue<int> q;
        q.push(0);
        vis[0] = 1;
        while(!q.empty()){
            int node = q.front();
            q.pop();
            ans.push_back(node);
            for(int it : adj[node]){
                if(!vis[it]){
                    vis[it] = 1;
                    q.push(it);
                }
            }
        }
        return ans;
    }
    
    vector<int> bfsOfGraph(vector<vector<int>> &adj) {
        // number of vertices/nodes in a graph
        int V = adj.size();
        return bfs(adj,V);
    }
};