// Problem Name: Max Sum of a Pair With Equal Sum of Digits
// Problem Link: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/

class Solution {
    int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
    
    public int maximumSum(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = getSum(nums[i]);
            List<Integer> temp = mp.getOrDefault(sum, new ArrayList<>());
            temp.add(nums[i]);
            mp.put(sum, temp);
        }
        for (Map.Entry<Integer, List<Integer>> e : mp.entrySet()) {
            Collections.sort(e.getValue());
        }
        int mx = -1;
        for (Map.Entry<Integer, List<Integer>> e : mp.entrySet()) {
            if (e.getValue().size() > 1) {
                mx = Math.max(mx, e.getValue().get(e.getValue().size() - 1) +
                                e.getValue().get(e.getValue().size() - 2));
            }
        }
        return mx;
    }
}