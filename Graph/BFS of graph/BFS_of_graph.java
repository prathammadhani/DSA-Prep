// Problem Name: BFS of graph
// Problem Link: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer node = q.remove();
            ans.add(node);
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        return bfs(adj,V);
    }
}