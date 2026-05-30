//Problem Name - Selection Sort
//Problem Link - https://www.geeksforgeeks.org/problems/selection-sort/1

//Selection Sort - Select minimum element from start and swaps
class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        for(int i = 0;i<n-1;i++) {
            int mini = i;
            for(int j = i+1;j<n;j++) {
                if(arr[j]<arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }
}