// Problem Name: Maximum Subarray
// Problem Link: https://leetcode.com/problems/maximum-subarray/description/

//Approach 1: Brute Force
class Solution {
    // Brute Force - O(N^2) - Time Limit Exceeded (TLE)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i, sum = 0; j < n; j++) {
                sum += nums[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}

// Approach 2: Kadane's Algorithm
class Solution {
    // Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans= Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}