//Problem Name: Mirror Distance of an Integer
//Problem Link: https://leetcode.com/problems/mirror-distance-of-an-integer/description/

class Solution {
    public int reverseNum(int num) {
        int reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + (num % 10);
            num /= 10;
        }
        return reverseNum;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverseNum(n));
    }
}