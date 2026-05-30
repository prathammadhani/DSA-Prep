//Problem Name - Bubble Sort
//Problem Link - https://www.geeksforgeeks.org/problems/bubble-sort/1

//Bubble Sort - Push the maximum element to the last by adjacent swaps
class Solution {
	public void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i<n; i++) {
			boolean flag = false;
			for (int j = 0; j<n - i-1; j++) {
				if (arr[j]>arr[j + 1]) {
					flag = true;
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			if (!flag) {
				break;
			}
		}
	}
}
