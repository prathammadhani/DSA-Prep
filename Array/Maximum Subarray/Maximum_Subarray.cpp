// Problem Name: Maximum Subarray
// Problem Link: https://leetcode.com/problems/maximum-subarray/description/

// Approach 1: Brute Force
class Solution {
public:
    // Brute Force - O(N^2) - Time Limit Exceeded (TLE)
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int ans = INT_MIN;
        for (int i = 0; i < n; i++) {
            for (int j = i, sum = 0; j < n; j++) {
                sum += nums[j];
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};

// Approach 2: Kadane's Algorithm
class Solution {
public:
    // Kadane's Algorithm
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int ans = INT_MIN;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans = max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
};