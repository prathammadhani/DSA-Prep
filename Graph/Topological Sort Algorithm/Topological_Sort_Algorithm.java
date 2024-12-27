// Problem Name: Topological Sort Algorithm
// Problem Link: https://www.geeksforgeeks.org/problems/topological-sort/1

// DFS Approach
class Solution {

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, adj, vis, st);
            }
        }
        st.push(node);
    }
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0;i < V;i++) {
            if (vis[i] == false) {
                dfs(i, adj, vis, st);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
}

// Kahn's Algorithm (Topological Sort - BFS Approach)
class Solution {
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] inDegree = new int[V];
        for (int i = 0;i < V;i++) {
            for (Integer it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V;i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (Integer it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return ans;
    }
}