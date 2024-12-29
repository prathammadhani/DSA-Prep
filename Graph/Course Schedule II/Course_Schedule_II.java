// Problem Name: Course Schedule II
// Problem Link: https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        int n = prerequisites.length;
        List<Integer>[] adj = new List[V];
        int[] inDegree = new int[V];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        int k = 0;
        int[] ans = new int[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            ans[k++] = node;
            if (adj[node] != null) {
                for (Integer it : adj[node]) {
                    inDegree[it]--;
                    if (inDegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
        }
        return count == V ? ans : new int[0];
    }
}