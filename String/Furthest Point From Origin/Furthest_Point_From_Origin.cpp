//Problem Name: Furthest Point From Origin
//Problem Link: https://leetcode.com/problems/furthest-point-from-origin/

//Approach 1
class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int n = moves.size();
        int cntl = 0, cntr = 0;
        for (int i = 0; i < n; i++) {
            if (moves[i] == '_') {
                cntl++;
                cntr++;
            } else if (moves[i] == 'L') {
                cntl++;
                cntr--;
            } else if (moves[i] == 'R') {
                cntr++;
                cntl--;
            }
        }
        return max(cntl, cntr);
    }
};

//Approach 2
class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int n = moves.size();
        int cntl = 0, cntr = 0, cntb = 0;
        for (int i = 0; i < n; i++) {
            if (moves[i] == 'L') {
               cntl++;
            } else if (moves[i] == 'R') {
                cntr++;
            } else {
                cntb++;
            }
        }
        return abs(cntl - cntr) + cntb;
    }
};