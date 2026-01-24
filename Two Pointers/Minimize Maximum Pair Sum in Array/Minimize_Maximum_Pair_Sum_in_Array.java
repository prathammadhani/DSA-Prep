//Problem Name: Minimize Maximum Pair Sum in Array
//Problem Link: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/ 

class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = n-1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i<n/2;i++) {
            ans = Math.max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }
        return ans;
    }
}