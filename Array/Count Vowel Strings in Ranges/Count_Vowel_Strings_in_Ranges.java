// Problem Name: Count Vowel Strings in Ranges
// Problem Link: https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n+1];
        for(int i = 0;i<n;i++) {
            String curr = words[i];
            if(isVowel(curr.charAt(0)) && isVowel(curr.charAt(curr.length()-1))) prefix[i+1] = prefix[i] + 1;
            else prefix[i+1] = prefix[i];
        }
        int[] ans = new int[queries.length];
        int k = 0;
        for(int i = 0;i<queries.length;i++) {
            int[] q = queries[i];
            ans[k] = prefix[q[1]+1] - prefix[q[0]];
            k++; 
        }
        return ans;
    }
}