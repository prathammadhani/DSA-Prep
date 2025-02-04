// Problem Name: Maximum Ascending Subarray Sum
// Problem Link: https://leetcode.com/problems/maximum-ascending-subarray-sum/description/

// Approach 1: Brute Force
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1]) {
                    sum += nums[j];
                } else
                    break;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

// Approach 2: Single Pass
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                sum = 0;
            }
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}