// Problem Name: Make Lexicographically Smallest Array by Swapping Elements
// Problem Link: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/ 

class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        int n = nums.size();
        vector<pair<int, int>> vp;
        for (int i = 0; i < n; i++) {
            vp.push_back({nums[i], i});
        }
        sort(vp.begin(), vp.end());
        int left = 0, right = 1;
        while (right < n) {
            vector<int> pos = {vp[left].second};
            while (right < n &&
                   abs(vp[right].first - vp[right - 1].first) <= limit) {
                pos.push_back(vp[right].second);
                right++;
            }

            sort(pos.begin(), pos.end());
            for (int i = 0; i < right - left; i++) {
                nums[pos[i]] = vp[left + i].first;
            }
            left = right;
            right++;
        }
        return nums;
    }
};