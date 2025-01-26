// Problem Name: Count Partitions with Even Sum Difference
// Problem Link: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/

import java.io.*;
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int sum2 = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            sum2 += nums[i];
            sum -= nums[i];
            if ((sum - sum2) % 2 == 0)
                ans++;
        }
        return ans;
    }
}