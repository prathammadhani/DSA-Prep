//Problem Name: Minimum Operations to Collect Elements
//Problem Link: https://leetcode.com/problems/minimum-operations-to-collect-elements/description/

class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int n = nums.size();
        int ans = 0;
        vector<int> vis(k + 1, 0);
        int cnt = k;
        for (int i = n - 1; i >= 0 && cnt > 0; i--) {
            if (nums[i] <= k && vis[nums[i]] == 0) {
                cnt--;
                vis[nums[i]] = 1;
            }
            ans++;
        }
        return ans;
    }
};