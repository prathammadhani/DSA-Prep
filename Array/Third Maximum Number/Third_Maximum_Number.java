//Problem Name: Third Maximum Number
//Problem Link: https://leetcode.com/problems/third-maximum-number/

class Solution {
    public int thirdMax(int[] nums) {
        long mx1 = Long.MIN_VALUE, mx2 = Long.MIN_VALUE, mx3 = Long.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++) {
            if(mx1 == nums[i] || mx2 == nums[i] || mx3 == nums[i]) continue;
            if(mx1<=nums[i]) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = nums[i];
            } else if(mx2<=nums[i]) {
                mx3 = mx2;
                mx2 = nums[i];
            } else if(mx3<=nums[i]) {
                mx3 = nums[i];
            }
        }
        if(mx3==Long.MIN_VALUE) return (int) mx1;
        return (int) mx3;
    }
}