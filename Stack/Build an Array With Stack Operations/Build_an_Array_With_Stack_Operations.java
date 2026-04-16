//Problem Name: Build an Array With Stack Operations
//Problem Link: https://leetcode.com/problems/build-an-array-with-stack-operations/description/

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int currIndex = 0;
        for (int i = 1; i <= n && currIndex < target.length; i++) {
            if (target[currIndex] != i) {
                ans.add("Push");
                ans.add("Pop");
            } else {
                ans.add("Push");
                currIndex++;
            }
        }
        return ans;
    }
}