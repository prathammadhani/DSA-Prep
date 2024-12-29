// Problem Name: Course Schedule
// Problem Link: https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            if (adj[node] != null) {
                for (Integer it : adj[node]) {
                    inDegree[it]--;
                    if (inDegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
        }
        return count == V ? true : false;
    }
}