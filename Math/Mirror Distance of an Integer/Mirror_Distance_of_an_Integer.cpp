//Problem Name: Mirror Distance of an Integer
//Problem Link: https://leetcode.com/problems/mirror-distance-of-an-integer/description/

class Solution {
public:
    int reverseNum(int n) {
        int num = 0;
        while (n > 0) {
            num = num * 10 + (n % 10);
            n /= 10;
        }
        return num;
    }

    int mirrorDistance(int n) { 
        return abs(n - reverseNum(n)); 
    }
};