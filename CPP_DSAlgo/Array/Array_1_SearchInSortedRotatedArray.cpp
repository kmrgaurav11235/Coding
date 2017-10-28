//Search Array that has beeb sorted and then rotated. Full problem at bottom
#include <iostream>
#include <fstream>
#define MAX 100005
#define TEST 100

using namespace std;

int findBiggest(int a[], int low, int high)
{
    if(low > high)
        return -1;
    else if(low == high)
        return low;

    int mid = (low + high)/2;
    if(mid < high && a[mid] > a[mid + 1])
        return mid;
    else if(low < mid && a[mid - 1] > a[mid])
        return (mid - 1);
    else if(a[low] >= a[mid])
        return findBiggest(a, low, mid - 1);
    else
        return findBiggest(a, mid + 1, high);
}

int binarySearch(int a[], int low, int high, int key)
{
    if(low > high)
        return -1;
    int mid = (low + high)/2;
    if(a[mid] == key)
        return mid;
    else if(a[mid] < key)
        return binarySearch(a, mid + 1, high, key);
    else
        return binarySearch(a, low, mid - 1, key);
}

int searchInSortedRotatedArray(int a[], int n, int key)
{
    int pivot = findBiggest(a, 0, n - 1);

    if(pivot == -1)
        return binarySearch(a, 0, n - 1, key);
    else if(a[pivot] == key)
        return pivot;
    else if (key >= a[0])
        return binarySearch(a, 0, pivot - 1, key);
    else
        return binarySearch(a, pivot + 1, n - 1, key);
}

int main()
{
    int i, noOfTestCases, n, j;
    int key;
    int a[MAX];
    int indx[TEST];

    cin >> noOfTestCases;
    for (i = 0; i < noOfTestCases; i++)
    {
        cin >> n;
        for(j = 0; j < n; j++)
        {
            cin >> a[j];
        }
        cin >> key;
        indx[i] = searchInSortedRotatedArray(a, n, key);
    }
    /*
    ifstream inputFile("SearchInRotatedSortedArray.txt");

    inputFile >> noOfTestCases;
    cout << "No of test cases: " << noOfTestCases << endl;
    for (i = 0; i < noOfTestCases; i++)
    {
        inputFile >> n;
        cout << "N = " << n << endl;
        for(j = 0; j < n; j++)
        {
            inputFile >> a[j];
            cout << "A[i] = " << a[j] << endl;
        }
        inputFile >> key;
        cout << "Key = " << key << endl;

	    //displayArray(a, n);
	    for(int i = 0; i < n; i++)
            cout << a[i] << " ";
        cout << endl;

        cout << "Answer: " << (indx[i] = searchInSortedRotatedArray(a, n, key)) << endl;
    }
    */

    for (i = 0; i < noOfTestCases; i++)
    {
        cout << indx[i] << endl;
    }

    return 0;
}

/*Given a sorted and rotated array (rotated at some point) A[ ], and given an element K, the task is to find the index of
the given element K in the array A[ ]. The array has no duplicate elements. If the element does not exist in the array, print -1.

Input:
The first line of the input contains an integer T, depicting the total number of test cases. Then T test cases follow.
Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given
array. Second line of each test case contains N space separated integers denoting the elements of the array A[ ].
Third line of each test case contains an integer K denoting the element to be searched in the array.

Output:
Corresponding to each test case, print in a new line, the index of the element found in the array.  If element is not present,
then print -1.


Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100005
0 ≤ A[i] ≤ 10000005
1 ≤ k ≤ 100005


Example:

Input
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6


Output
5
1
-1
*/
