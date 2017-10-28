/*
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all 
elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} 
is 6 and LIS is {10, 22, 33, 50, 60, 80}.

More Examples:
Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

*/

#include <iostream>

using namespace std;

void display(int a[], int n)
{
	int i;
	for(i = 0; i < n; i++)
		cout << a[i] << " ";
	cout << endl;
}

int longestIncreasingSubsequence(int a[], int n)
{
	int lis[n + 1];
	lis[0] = 0;
	
	for(int i = 1; i <= n; i++)
	{
		int maxVal = 0;
		for(int j = 1; j <= i; j++)
		{
			if((a[i - 1] > a[j - 1]) && (lis[j] + 1 > maxVal))
				maxVal = lis[j] + 1;
			else if((a[i - 1] <= a[j - 1]) && (1 > maxVal))
				maxVal = 1;
		}
		lis[i] = maxVal;
	}
	cout << "LIS Array is: ";
	display(lis, n+1);
	
	int maxLis = 0;
	for(int i = 1; i <= n; i++)
		if(maxLis < lis[i])
			maxLis = lis[i];
			
	return maxLis;
}

int main()
{
    int a1[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    int n1 = 9;
    
    cout << "For Array: ";
    display(a1, n1);
    cout << "Length of longest increasing subsequence is: " << longestIncreasingSubsequence(a1, n1) << ".\n";
    
    int a2[] = {3, 10, 2, 1, 20};
    int n2 = 5;
    
    cout << "\nFor Array: ";
    display(a2, n2);
    cout << "Length of longest increasing subsequence is: " << longestIncreasingSubsequence(a2, n2) << ".\n";
    
    int a3[] = {3, 2};
    int n3 = 2;
    
    cout << "\nFor Array: ";
    display(a3, n3);
    cout << "Length of longest increasing subsequence is: " << longestIncreasingSubsequence(a3, n3) << ".\n";
    
    int a4[] = {50, 3, 10, 7, 40, 80};
    int n4 = 6;
    
    cout << "\nFor Array: ";
    display(a4, n4);
    cout << "Length of longest increasing subsequence is: " << longestIncreasingSubsequence(a4, n4) << ".\n";
    
    return 0;
}

/*
Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.

Then, L(i) can be recursively written as:
L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.

To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.

Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using solutions to subproblems.
 */
