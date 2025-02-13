// Problem Name: Minimum Operations to Exceed Threshold Value II
// Problem Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ans = 0;
        for(int i = 0;i<n;i++) {
            pq.add(nums[i] * 1L);
        }
        while(pq.peek() < k) {
            Long x = pq.poll();
            Long y = pq.poll();
            pq.add(x * 2 + y);
            ans++;
        }
        return ans;
    }
}