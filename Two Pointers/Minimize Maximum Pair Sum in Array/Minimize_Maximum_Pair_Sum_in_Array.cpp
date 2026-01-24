//Problem Name: Minimize Maximum Pair Sum in Array
//Problem Link: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/ 

class Solution {
public:
    int minPairSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        int left = 0, right = n-1;
        int ans = INT_MIN;
        for (int i = 0;i<n/2;i++) {
            ans = max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }
        return ans;
    }
};