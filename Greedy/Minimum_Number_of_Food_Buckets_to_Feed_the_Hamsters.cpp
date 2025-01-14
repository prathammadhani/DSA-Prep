// Problem Name: Minimum Number of Food Buckets to Feed the Hamsters
// Problem Link: https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/description/

class Solution {
public:
    int minimumBuckets(string s) {
        int n = s.size();
        if (n == 1 && s[0] == 'H')
            return -1;
        else if (n >= 2 && s[0] == 'H' && s[1] == 'H')
            return -1;
        else if (n >= 2 && s[n - 1] == 'H' && s[n - 2] == 'H')
            return -1;
        for (int i = 1; i < n - 1; i++) {
            if (s[i] == 'H') {
                if (s[i - 1] == 'H' && s[i + 1] == 'H')
                    return -1;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'H')
                cnt1++;
        }
        for (int i = 0; i < n - 2;) {
            if (s[i] == 'H' && s[i + 1] == '.' && s[i + 2] == 'H') {
                cnt2++;
                i += 3;
            } else {
                i++;
            }
        }
        return cnt1 - cnt2;
    }
};