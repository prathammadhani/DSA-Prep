//Problem Name: Range Sum Query - Immutable
//Problem Link: https://leetcode.com/problems/range-sum-query-immutable/

class NumArray {

    List<Integer> prefixSum = new ArrayList<>();
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum.add(nums[0]);
        for(int i = 1;i<n;i++) {
            prefixSum.add(prefixSum.get(i-1) + nums[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefixSum.get(right);
        return prefixSum.get(right) - prefixSum.get(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */