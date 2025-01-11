// Problem Name: Form Array by Concatenating Subarrays of Another Array
// Problem Link: https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/description/

class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        int m = nums.size();
        int n = groups.size();
        map<vector<int>, vector<pair<int, int>>> mp;
        int k = 0;
        int cnt = 0;
        for (vector<int> group : groups) {
            int sz = group.size();
            bool subArrayFound = false;
            for (int i = 0; i < m - sz + 1; i++) {
                vector<int> temp(nums.begin() + i, nums.begin() + i + sz);
                if (temp == group) {
                    mp[temp].push_back({i, i + sz - 1});
                    subArrayFound = true;
                }
            }
            if (subArrayFound)
                cnt++;
            k++;
        }

        if (cnt != n)
            return false;
        bool flag = true;
        for (int i = 0; i < n - 1; i++) {
            vector<pair<int, int>> vp1 = mp[groups[i]];
            vector<pair<int, int>> vp2 = mp[groups[i + 1]];
            bool isValid = false;
            for (auto it : vp1) {
                for (auto it2 : vp2) {
                    if (it.second < it2.first) {
                        isValid = true;
                        break;
                    }
                }
                if (!isValid) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
};