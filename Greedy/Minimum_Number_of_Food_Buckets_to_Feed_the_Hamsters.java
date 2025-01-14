// Problem Name: Minimum Number of Food Buckets to Feed the Hamsters
// Problem Link: https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/description/

class Solution {
    public int minimumBuckets(String s) {
        int n = s.length();
        if (n == 1 && s.charAt(0) == 'H')
            return -1;
        else if (n >= 2 && s.charAt(0) == 'H' && s.charAt(1) == 'H')
            return -1;
        else if (n >= 2 && s.charAt(n - 1) == 'H' && s.charAt(n - 2) == 'H')
            return -1;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == 'H') {
                if (s.charAt(i - 1) == 'H' && s.charAt(i + 1) == 'H')
                    return -1;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'H') {
                cnt1++;
            }
        }
        for (int i = 0; i < n - 2;) {
            if (s.charAt(i) == 'H' && s.charAt(i + 1) == '.' && s.charAt(i + 2) == 'H') {
                cnt2++;
                i += 3;
            } else {
                i++;
            }
        }
        return cnt1 - cnt2;
    }
}