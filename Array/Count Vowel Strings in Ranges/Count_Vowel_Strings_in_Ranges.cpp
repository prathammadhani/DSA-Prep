// Problem Name: Count Vowel Strings in Ranges
// Problem Link: https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

class Solution {
public:
    bool isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        int n = words.size();
        vector<int> prefix(n+1);
        for(int i = 0;i<n;i++){
            if(isVowel(words[i][0]) && isVowel(words[i][words[i].size()-1])) prefix[i+1] = prefix[i] + 1;
            else prefix[i+1] = prefix[i];    
        }
        vector<int> ans;
        for(auto& q : queries) {
            int curr = prefix[q[1]+1] - prefix[q[0]];
            ans.push_back(curr);
        }
        return ans;
    }
};