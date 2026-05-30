//Problem Name - Bubble Sort
//Problem Link - https://www.geeksforgeeks.org/problems/bubble-sort/1

class Solution {
	public:
	void bubbleSort(vector<int>& arr) {
		int n = arr.size();
		for (int i = 0; i<n; i++) {
			bool flag = false;
			for (int j = 0; j<n - i-1; j++) {
				if (arr[j]>arr[j + 1]) {
					flag = true;
					swap(arr[j], arr[j + 1]);
				}
			}
			if (!flag) {
				break;
			}
		}
	}
};
