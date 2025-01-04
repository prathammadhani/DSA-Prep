//Problem Name: Unique Length-3 Palindromic Subsequences
//Problem Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description

class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.length();
        unordered_map<char, pair<int, int>> mp;
        for (int i = 0; i < n; i++) {
            if (mp.find(s[i]) == mp.end()) {
                mp[s[i]].first = mp[s[i]].second = i;
            } else {
                mp[s[i]].second = i;
            }
        }
        int ans = 0;
        for (auto& [ch,p] : mp) {
            int start = p.first;
            int last = p.second;
            unordered_set<char> st;
            for (int i = start + 1; i < last; i++) {
                st.insert(s[i]);
            }
            ans += st.size();
        }
        return ans;
    }
};
