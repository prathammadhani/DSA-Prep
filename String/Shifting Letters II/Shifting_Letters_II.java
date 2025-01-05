// Problem Name: Shifting Letters II
// Problem Link: https://leetcode.com/problems/shifting-letters-ii/description

// Approach - Prefix Sum - Difference Array Technique
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];
        Arrays.fill(diff, 0);
        for(int i = 0;i<shifts.length;i++){
            if(shifts[i][2] == 0) {
                diff[shifts[i][0]]--;
                if(shifts[i][1]+1 < n) diff[shifts[i][1] + 1]++;
            } else {
                diff[shifts[i][0]]++;
                if(shifts[i][1]+1 < n) diff[shifts[i][1] + 1]--;
            }
        }
        int[] prefixSum = new int[n];
        Arrays.fill(prefixSum, 0);
        prefixSum[0] = diff[0] % 26;
        for(int i = 1;i<n;i++) {
            prefixSum[i] = (prefixSum[i-1] + diff[i]) % 26;
        }

        String ans = "";
        for(int i = 0;i<n;i++) {
            char temp;
            if(prefixSum[i] >= 0) temp = (char) ('a' + ((s.charAt(i) - 'a' + prefixSum[i]) % 26));
            else temp = (char) ('a' + ((s.charAt(i) - 'a' + prefixSum[i]+26) % 26));
            ans+=temp;
        }
        return ans;
    }
}