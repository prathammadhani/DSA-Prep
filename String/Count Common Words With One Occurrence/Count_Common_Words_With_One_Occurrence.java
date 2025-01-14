// Problem Name: Count Common Words With One Occurrence
// Problem Link: https://leetcode.com/problems/count-common-words-with-one-occurrence/description/

class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> mp1 = new HashMap<String, Integer>();
        HashMap<String, Integer> mp2 = new HashMap<String, Integer>();
        for (int i = 0; i < words1.length; i++) {
            mp1.put(words1[i], mp1.getOrDefault(words1[i], 0) + 1);
        }
        for (int i = 0; i < words2.length; i++) {
            mp2.put(words2[i], mp2.getOrDefault(words2[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < words1.length; i++) {
            if (mp2.containsKey(words1[i]) && mp1.get(words1[i]) == 1 &&
                mp2.get(words1[i]) == 1)
                ans++;
        }
        return ans;
    }
}