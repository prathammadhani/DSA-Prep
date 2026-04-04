//Problem Name: Third Maximum Number
//Problem Link: https://leetcode.com/problems/third-maximum-number/

class Solution {
public:
    int thirdMax(vector<int>& nums) {
        long long mx1 = LLONG_MIN, mx2 = LLONG_MIN, mx3 = LLONG_MIN;
        int n = nums.size();
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
        if(mx3 == LLONG_MIN) {
            int ans = (int) mx1;
            return ans;
        }
        int ans = (int) mx3;
        return ans;
    }
};