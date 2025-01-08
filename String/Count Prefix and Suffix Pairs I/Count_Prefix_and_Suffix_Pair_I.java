// Problem Name: Count Prefix and Suffix Pairs I
// Problem Link: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description

// Approach-1: Brute Force
class Solution {
    public boolean isPrefixAndSuffix(String str1, String str2) {
        boolean isPrefix = true, isSuffix = true;
        if(str1.length()>str2.length()) return false;
        for(int i = 0;i<str1.length();i++) {
            if(str1.charAt(i)!=str2.charAt(i)) {
                isPrefix = false;
                break;
            }
        }
        int k = str2.length()-1;
        for(int i = str1.length()-1;i>=0;i--){
            if(str1.charAt(i)!=str2.charAt(k)) {
                isSuffix = false;
                break;
            } else k--;
        }
        return isPrefix && isSuffix;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for(int i = 0;i<n;i++) {
            for(int j = i+1;j<n;j++) {
                if(isPrefixAndSuffix(words[i],words[j]) == true) {
                    ans++;
                }
            }
        }
        return ans;
    }
}