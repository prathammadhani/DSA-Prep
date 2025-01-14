// Problem Name: Find the Prefix Common Array of Two Arrays
// Problem Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashMap<Integer, Integer> mp1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mp2 = new HashMap<Integer, Integer>();
        int[] prefix = new int[n];
        prefix[0] = (A[0] == B[0]) ? 1 : 0;
        mp1.put(A[0], 1);
        mp2.put(B[0], 1);
        for(int i = 1;i<n;i++) {
            int cnt = 0;
            if(A[i] == B[i]) {
                cnt++;
            }
            if(mp1.containsKey(B[i])) {
                cnt++;
            }
            if(mp2.containsKey(A[i])) {
                cnt++;
            }
            prefix[i] = prefix[i-1] + cnt;
            if(mp1.containsKey(A[i])) {
                mp1.put(A[i], mp1.get(A[i]) + 1);
            } else {
                mp1.put(A[i], 1);
            }

            if(mp2.containsKey(B[i])) {
                mp2.put(B[i], mp2.get(B[i]) + 1);
            } else {
                mp2.put(B[i], 1);
            }
        }
        return prefix;
    }
}