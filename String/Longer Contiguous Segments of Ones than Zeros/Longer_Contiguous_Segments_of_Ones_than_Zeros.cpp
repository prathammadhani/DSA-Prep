// Problem Name: Longer Contiguous Segments of Ones than Zeros
// Problem Link: https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/description/

class Solution {
    public:
        bool checkZeroOnes(string s) {
            int n = s.length();
            int cntOne = 0, cntZero = 0;
            int maxCntOne = 0, maxCntZero = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '1') {
                    maxCntZero = max(maxCntZero, cntZero);
                    cntZero = 0;
                    cntOne++;
                } else {
                    maxCntOne = max(maxCntOne, cntOne);
                    cntOne = 0;
                    cntZero++;
                }
            }
            maxCntZero = max(maxCntZero, cntZero);
            maxCntOne = max(maxCntOne, cntOne);
            return maxCntOne > maxCntZero;
        }
    };

