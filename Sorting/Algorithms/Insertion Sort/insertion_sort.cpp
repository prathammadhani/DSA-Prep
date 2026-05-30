//Probllem Name - Insertion Sort
//Problem Link - https://www.geeksforgeeks.org/problems/insertion-sort/1

//Insertion Sort - Takes an element and place it in its correct order
class Solution {
	public:
	void insertionSort(vector<int>& arr) {
		int n = arr.size();
		for (int i = 0; i<n; i++) {
		    int j = i;
			while(j > 0 && arr[j-1] > arr[j]) {
			    swap(arr[j - 1], arr[j]);
			    j--;
			}
		}
	}
};
