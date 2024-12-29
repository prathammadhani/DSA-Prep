// Problem Name: Course Schedule II
// Problem Link: https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        int V = numCourses;
        unordered_map<int, vector<int>> adj;
        vector<int> inDegree(V, 0);
        for (auto prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            adj[v].push_back(u);
            inDegree[u]++;
        }
        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        int count = 0;
        vector<int> ans;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            ans.push_back(node);
            count++;
            for (auto it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0)
                    q.push(it);
            }
        }
        return ans.size() == V ? ans : vector<int>();
    }
};