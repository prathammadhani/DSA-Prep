// Problem Name: Minimum Number of Operations to Move All Balls to Each Box
// Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description

// Approach-1: Brute Force
class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n = boxes.size();
        vector<int> ans(n,0);
        for(int i = 0;i<n;i++) {
            if(boxes[i] == '1') {
                for(int j = 0;j<n;j++) {
                    ans[j]+=abs(j-i);
                }
            }
        }
        return ans;
    }
};

// Approach-2: Prefix Sum
class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n = boxes.size();
        int sum = 0;
        int right_ones = 0;
        for(int i = 0;i<n;i++) {
            if(boxes[i] == '1') {
                sum+=i;
                right_ones++;
            }
        }

        vector<int> ans(n,0);
        int prefix_sum = 0;
        int left_ones = 0;
        for(int i = 0;i<n;i++) {
            int moves = sum + prefix_sum;
            ans[i] = moves;

            if(boxes[i] == '1') {
                left_ones++;
                right_ones--;
            }

            prefix_sum+=left_ones;
            sum-=right_ones;
        }

        return ans;
    }
};