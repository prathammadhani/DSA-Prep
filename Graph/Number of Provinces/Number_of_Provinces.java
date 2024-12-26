// Problem Name: LC - 547. Number of Provinces
// Problem Link: https://leetcode.com/problems/number-of-provinces/description/

// BFS Approach
class Solution {
    public void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while (!q.isEmpty()) {
            Integer currNode = q.poll();
            for (Integer it : adj.get(currNode)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                ans++;
                bfs(i, adj, vis);
            }
        }
        return ans;
    }
}

// DFS Approach
class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                dfs(it,adj,vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(vis[i] == false){
                ans++;
                dfs(i,adj,vis);
            }
        }
        return ans;
    }
}