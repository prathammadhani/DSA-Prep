//Problem Link: https://leetcode.com/problems/longest-balanced-substring-i/description/
//Problem Name: Longest Balanced Substring I

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0;i<n;i++) {
            int[] freq = new int[26];
            Arrays.fill(freq,0);
            for(int j = i;j<n;j++) {
                freq[s.charAt(j)-'a']++;
                boolean flag = true;
                int cmp = 0;
                for(int k = 0;k<26;k++) {
                    if(freq[k]!=0 && cmp == 0) {
                        cmp = freq[k];
                    } else if(freq[k]!=0 && cmp!=freq[k]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) ans = Math.max(ans, j-i+1);
            }
        }
        return ans;
    }
}