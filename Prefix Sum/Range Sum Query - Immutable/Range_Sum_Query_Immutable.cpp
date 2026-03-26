//Problem Name: Range Sum Query - Immutable
//Problem Link: https://leetcode.com/problems/range-sum-query-immutable/

class NumArray {
public:

    vector<int> prefixSum;
    NumArray(vector<int>& nums) {
        int n = nums.size();
        prefixSum.push_back(nums[0]);
        for(int i = 1;i<n;i++) {
            prefixSum.push_back(prefixSum[i-1] + nums[i]);
        }
    }
    
    int sumRange(int left, int right) {
        if(left == 0) return prefixSum[right];
        return prefixSum[right] - prefixSum[left-1];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */