// Problem Name: First Completely Painted Row or Column
// Problem Link: https://leetcode.com/problems/first-completely-painted-row-or-column/description/

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        HashMap<Integer, int[]> mp = new HashMap<>();
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                int[] coordinate = {i,j};
                mp.put(mat[i][j], coordinate);
            }
        }

        for(int i = 0;i<arr.length;i++) {
            int[] coordinate = mp.get(arr[i]);
            row[coordinate[0]]++;
            col[coordinate[1]]++;
            if(row[coordinate[0]] == n || col[coordinate[1]] == m) return i;
        }
        return -1;
    }
}