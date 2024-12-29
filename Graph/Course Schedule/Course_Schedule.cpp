// Problem Name: Course Schedule
// Problem Link: https://leetcode.com/problems/course-schedule/

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int V = numCourses;
        unordered_map<int, vector<int>> adj;
        for (auto prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            adj[v].push_back(u);
        }
        vector<int> inDegree(V, 0);
        for (int i = 0; i < V; i++) {
            for (auto it : adj[i]) {
                inDegree[it]++;
            }
        }
        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        int count = 0;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            count++;
            for (auto it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0)
                    q.push(it);
            }
        }
        return count == V;
    }
};