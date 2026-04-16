//Problem Name: Build an Array With Stack Operations
//Problem Link: https://leetcode.com/problems/build-an-array-with-stack-operations/description/

class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        vector<string> ans;
        int curr = 0;
        for (int i = 1; i <= n && curr < target.size(); i++) {
            if (target[curr] != i) {
                ans.push_back("Push");
                ans.push_back("Pop");
            } else {
                ans.push_back("Push");
                curr++;
            }
        }
        return ans;
    }
};