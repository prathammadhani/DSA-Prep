// Problem Name: DFS of graph
// Problem Link: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> ans = new ArrayList<>();
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node] = true;
        ans.add(node);
        for (Integer it : adj.get(node)) {
            if(vis[it] == false) {
                dfs(it,adj,vis);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        dfs(0,adj,vis);
        return ans;
    }
}