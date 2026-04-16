//Problem Name: Minimum Operations to Collect Elements
//Problem Link: https://leetcode.com/problems/minimum-operations-to-collect-elements/description/

class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        int[] vis = new int[k + 1];
        int cnt = k;
        for (int i = n - 1; i >= 0 && cnt > 0; i--) {
            if (nums.get(i) <= k && vis[nums.get(i)] == 0) {
                cnt--;
                vis[nums.get(i)] = 1;
            }
            ans++;
        }
        return ans;
    }
}