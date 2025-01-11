// Problem Name: Largest Merge Of Two Strings
// Problem Link: https://leetcode.com/problems/largest-merge-of-two-strings/description/

class Solution {
public:
    string largestMerge(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        int i = 0, j = 0;
        string ans;
        while (i < n && j < m) {
            if (word1[i] > word2[j]) {
                ans += word1[i];
                i++;
            } else if (word1[i] < word2[j]) {
                ans += word2[j];
                j++;
            } else {
                if (word1.substr(i) > word2.substr(j)) {
                    ans += word1[i++];
                } else {
                    ans += word2[j++];
                }
            }
        }
        while (i < n) {
            ans += word1[i];
            i++;
        }
        while (j < m) {
            ans += word2[j];
            j++;
        }
        return ans;
    }
};