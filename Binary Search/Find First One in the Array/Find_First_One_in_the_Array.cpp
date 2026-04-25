#include<bits/stdc++.h>
using namespace std;

int check(int arr[], int mid) {
	if(arr[mid] == 1) return 1;
	else return 0;
}

int main() {
	cout<<"Enter number of elements in the array: ";
	int n;
	cin>>n;
	cout<<"Enter elements of the array: ";
	int arr[n];
	for(int i = 0;i<n;i++) cin>>arr[i];
	int low = 0;
    int high = n-1;
    int ans = n;
    while(low<=high) {
    	int mid = low+(high-low)/2;
    	if(check(arr, mid) == 1) {
    		ans = mid;
    		high = mid-1;
    	} else {
    		low = mid+1;
    	}
    }
    cout<<ans<<endl;
	return 0;
}