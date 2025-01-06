// Problem Name: Minimum Number of Operations to Move All Balls to Each Box
// Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description

// Approach-1: Brute Force
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i = 0;i<n;i++) {
            if(boxes.charAt(i) == '1') {
                for(int j = 0;j<n;j++) {
                    ans[j]+=Math.abs(j-i);
                }
            }
        }
        return ans;
    }
}

// Approach-2: Prefix Sum
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int sum = 0;
        int right_ones = 0;
        for(int i = 0;i<n;i++) {
            if(boxes.charAt(i) == '1') {
                sum+=i;
                right_ones++;
            }
        }

        int[] ans = new int[n];
        int prefix_sum = 0;
        int left_ones = 0;
        for(int i = 0;i<n;i++) {
            int moves = sum + prefix_sum;
            ans[i] = moves;

            if(boxes.charAt(i) == '1') {
                left_ones++;
                right_ones--;
            }

            prefix_sum+=left_ones;
            sum-=right_ones;
        }

        return ans;
    }
}