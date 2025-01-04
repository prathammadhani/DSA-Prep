//Problem Name: Unique Length-3 Palindromic Subsequences
//Problem Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, int[]> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch, new int[] { i, i });
            } else {
                mp.get(ch)[1] = i;
            }
        }
        int ans = 0;
        for (Map.Entry<Character, int[]> entry : mp.entrySet()) {
            int[] range = entry.getValue();
            if (range[0] == range[1])
                continue;
            Set<Character> st = new HashSet<>();
            for (int i = range[0] + 1; i < range[1]; i++) {
                st.add(s.charAt(i));
            }
            ans += st.size();
        }
        return ans;
    }
}