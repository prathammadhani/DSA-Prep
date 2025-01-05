// Problem Name: Shifting Letters II
// Problem Link: https://leetcode.com/problems/shifting-letters-ii/description

// Approach - Prefix Sum - Difference Array Technique
class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        int n = s.length();
        vector<int> diff(n,0);
        for(int i = 0;i<shifts.size();i++){
            if(shifts[i][2] == 0) {
                diff[shifts[i][0]]--;
                if(shifts[i][1]+1 < n) diff[shifts[i][1] + 1]++;
            } else {
                diff[shifts[i][0]]++;
                if(shifts[i][1]+1 < n) diff[shifts[i][1] + 1]--;
            }
        }
        vector<int> prefixSum(n,0);
        prefixSum[0] = diff[0] % 26;
        for(int i = 1;i<n;i++) {
            prefixSum[i] = (prefixSum[i-1] + diff[i]) % 26;
        }

        string ans = "";
        for(int i = 0;i<n;i++) {
            char temp;
            if(prefixSum[i] >= 0) temp = 'a' + (s[i] - 'a' + prefixSum[i]) % 26;
            else temp = 'a' + (s[i] - 'a' + (prefixSum[i]+26)) % 26;
            ans+=temp;
        }
        return ans;
    }
};