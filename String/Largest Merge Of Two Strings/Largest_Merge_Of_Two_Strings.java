// Problem Name: Largest Merge Of Two Strings
// Problem Link: https://leetcode.com/problems/largest-merge-of-two-strings/description/

class Solution {
    public String largestMerge(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < n && j < m) {
            if (word1.charAt(i) > word2.charAt(j)) {
                ans.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                ans.append(word2.charAt(j));
                j++;
            } else {
                if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                    ans.append(word1.charAt(i));
                    i++;
                } else {
                    ans.append(word2.charAt(j));
                    j++;
                }
            }
        }
        while (i < n) {
            ans.append(word1.charAt(i));
            i++;
        }
        while (j < m) {
            ans.append(word2.charAt(j));
            j++;
        }
        return ans.toString();
    }
}

