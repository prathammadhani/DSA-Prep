// Problem Name: Max Sum of a Pair With Equal Sum of Digits
// Problem Link: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/

class Solution {
public:
    int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
    int maximumSum(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < n; i++) {
            mp[getSum(nums[i])].push_back(nums[i]);
        }
        for (auto& it : mp) {
            sort(it.second.begin(), it.second.end());
        }
        int mx = -1;
        for (auto& it : mp) {
            if (it.second.size() > 1) {
                mx = max(mx, it.second[it.second.size() - 1] +
                                    it.second[it.second.size() - 2]);
            }
        }
        return mx;
    }
};