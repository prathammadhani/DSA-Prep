// Problem Name: Minimum Operations to Exceed Threshold Value II
// Problem Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long, vector<long>, greater<long>> pq(nums.begin(), nums.end());
        int ans = 0;
        while(pq.top() < k) {
            long x = pq.top();
            pq.pop();
            long y = pq.top();
            pq.pop();
            pq.push(x * 2 + y);
            ans++;
        }
        return ans;
    }
};