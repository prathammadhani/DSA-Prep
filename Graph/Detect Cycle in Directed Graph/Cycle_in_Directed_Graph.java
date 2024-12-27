// Problem Name: Cycle in Directed Graph
// Problem Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0;i < V;i++) {
            for (Integer it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0;i < V;i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (Integer it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        if (count == V) return false;
        return true;
    }
}

