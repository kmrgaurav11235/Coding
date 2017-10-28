/*Merge an array of size n into another array of size m+n

There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and contains n elements. 
Merge these two arrays into the first array of size m+n such that the output is sorted.

Input: array with m+n elements (mPlusN[]).
2 NA 7 NA NA 10 NA

NA => Value is not filled/available in array mPlusN[]. There should be n such array blocks.

Input: array with n elements (N[]).
5 8 12 14

Output: N[] merged into mPlusN[] (Modified mPlusN[])
2 5 7 8 10 12 14
*/

#include<iostream>

using namespace std;

void swap(int & x, int & y)
{
	int temp = x;
	x = y;
	y = temp;
}

void moveToEnd(int a[], int size)
{
	int i = size - 1, j = size - 1;
	
	while(i >= 0 && j >= 0)
	{
		if(a[i] != -1 && a[j] != -1)
		{
			i--;
			j--;
		}
		else if(a[i] == -1 && a[j] == -1)
		{
			j--;
		}
		else if(a[i] == -1 && a[j] != -1)
		{
			a[i] = a[j];
			a[j] = -1;
			i--;
			j--;
		}
		else
		{
			i--;
		}
	}
}

void mergeMN(int a[], int b[], int m, int n)
{
	moveToEnd(a, m + n);
	
	int i = n, j = 0, k = 0;
	while(i < (m+n) && j < n)
	{
		if(a[i] <= b[j])
			a[k++] = a[i++];
		else
			a[k++] = b[j++];
	}
	while(i < (m+n))
		a[k++] = a[i++];
	while(j < n)
		a[k++] = b[j++];
}

int main()
{
    int n = 4, m = 3;
    int onlyN[] = {5, 8, 12, 14};
    int mPlusN[] = {2, -1, 7, -1, -1, 10, -1};

    int i;
    cout << "Array MPlusN:\n";
    for (i = 0; i < m + n; i++)
		if(i != -1)
			cout << mPlusN[i] << " ";
		else
			cout << "NA ";
	
	cout << "\nArray N:\n";
	for(i = 0; i < n; i++)
			cout << onlyN[i] << " ";
	
	mergeMN(mPlusN, onlyN, m, n);
	
    cout << "\nMerged Array:\n";
	for(i = 0; i < m + n; i++)
			cout << mPlusN[i] << " ";
	cout << endl;
    return 0;
}

/*
Let first array be mPlusN[] and other array be onlyN[]
1) Move m elements of mPlusN[] to end.
2) Start from nth element of mPlusN[] and 0th element of onlyN[] and merge them 
    into mPlusN[].
 */
