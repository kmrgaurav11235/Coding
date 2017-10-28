//Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
//e.g. {-2, -3, 4, -1, -2, 1, 5, -3}
//Ans = 7(4, -1, -2, 1, 5)
#include <iostream>

using namespace std;

int maxContigiousSum(int a[], int n, int & startIndx, int & endIndx)
{
    int i, currStart = 0, currMax = a[0], finalMax = a[0];
    for(i = 1; i < n; i++)
    {
        if(currMax + a[i] > a[i])
        {
            currMax = currMax + a[i];
        }
        else
        {
            currMax = a[i];
            currStart = i;
        }
        if(currMax > finalMax)
        {
            finalMax = currMax;
            startIndx = currStart;
            endIndx = i;
        }
    }
    return finalMax;
}

int main()
{
    int i, n = 8;
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    int startIndx = -1, endIndx = -1;
    int sum = maxContigiousSum(a, n, startIndx, endIndx);
    cout << "In Array:\n";
    for (i = 0; i < n; i++)
        cout << a[i] << " ";
    cout << "\nMax Contigious Sum = " << sum << " can be found at:\n";
    for (i = startIndx; i <= endIndx; i++)
        cout << a[i] << " ";
    cout << endl;
    return 0;
}
