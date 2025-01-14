// Problem Name: Find the Prefix Common Array of Two Arrays
// Problem Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description

class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        int n = A.size();
        unordered_map<int,int> mp1,mp2;
        vector<int> prefix(n,0);
        prefix[0] = (A[0] == B[0]);
        mp1[A[0]] = 1;
        mp2[B[0]] = 1;
        for(int i = 1;i<n;i++) {
            int cnt = 0;
            if(A[i] == B[i]) {
                cnt++;
            }
            if(mp2.find(A[i])!=mp2.end()) {
                cnt++;
            }
            if(mp1.find(B[i])!=mp1.end()) {
                cnt++;
            }
            prefix[i] = prefix[i-1] + cnt;
            mp1[A[i]]++;
            mp2[B[i]]++;
        }
        return prefix;
    }
};