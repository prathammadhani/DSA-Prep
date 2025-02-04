// Problem Name: Maximum Ascending Subarray Sum
// Problem Link: https://leetcode.com/problems/maximum-ascending-subarray-sum/description/

// Approach 1: Brute Force
class Solution {
public:
    // Brute Force - O(N^2)
    int maxAscendingSum(vector<int>& nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1]) {
                    sum += nums[j];
                } else
                    break;
            }
            ans = max(ans, sum);
        }
        return ans;
    }
};

// Approach 2: Single Pass
class Solution {
public:
    // Optimal Approach - Single Pass
    int maxAscendingSum(vector<int>& nums) {
        int n = nums.size();
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                sum = 0;
            }
            sum += nums[i];
            ans = max(ans, sum);
        }
        return ans;
    }
};