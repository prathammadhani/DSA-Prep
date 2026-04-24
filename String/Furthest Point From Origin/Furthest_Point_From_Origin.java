//Problem Name: Furthest Point From Origin
//Problem Link: https://leetcode.com/problems/furthest-point-from-origin/

//Approach 1
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int cntl = 0, cntr = 0;
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == '_') {
                cntl++;
                cntr++;
            } else if (moves.charAt(i) == 'L') {
                cntl++;
                cntr--;
            } else if (moves.charAt(i) == 'R') {
                cntr++;
                cntl--;
            }
        }
        return Math.max(cntl, cntr);
    }
}

//Approach 2
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int cntl = 0, cntr = 0, cntb = 0;
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') {
                cntl++;
            } else if (moves.charAt(i) == 'R') {
                cntr++;
            } else {
                cntb++;
            }
        }
        return Math.abs(cntl - cntr) + cntb;
    }
}