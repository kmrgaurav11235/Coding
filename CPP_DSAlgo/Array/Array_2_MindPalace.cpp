/*
A mind palace is something that lets you retrieve a given memory in the least time posible. For this,
you structure your mind palace in a very special way. Let a NxM Matrix denote the mind palace.
For fast retrieval you keep each row and each column sorted. Now given a memory X, you have to tell the position
of the memory in mind palace.

Input
Input begins with a line containing space separated N and M.
The next N lines each contain M numbers, each referring to a memory Y.
The next line contains Q, the number of queries.
The next Q lines contain a single element X, the memory you have to search in Sherlock's mind palace.

Output
If Y is present in Mr. Holmes memory, output its position (0-based indexing).
Else output "-1 -1" (quotes for clarity only).

Constraints
2 ≤ N,M ≤ 1000
2 ≤ Q ≤ 1000
-10^9 ≤ X,Y ≤ 10^9

Note : Large Input Files. Use faster I/O methods.

SAMPLE INPUT
5 5
-10 -5 -3 4 9
-6 -2 0 5 10
-4 -1 1 6 12
2 3 7 8 13
100 120 130 140 150
3
0
-2
170

SAMPLE OUTPUT
1 2
1 1
-1 -1
*/

#include <iostream>
#include <fstream>
#define MAX 1000

using namespace std;

void findIndices(double arr[][MAX], int n, int m, double key, int &x, int &y)
{
    int i = 0, j = m-1;
    while (i < n && j >= 0)
    {
        if(key == arr[i][j])
        {
            x = i;
            y = j;
            return;
        }
        else if(key < arr[i][j])
            j--;
        else
            i++;
    }
    x = -1;
    y = -1;
}

int main()
{
    ifstream inputFile("MindPalaceInput.txt");

    int n,m;
    inputFile >> n >> m;
    double arr[MAX][MAX];

    int i = 0, j = 0;

    while(inputFile >> arr[i][j])
    {
        if(i == (n - 1) && (j == (m - 1)) )
            break;
        else if(j == (m - 1))
        {
            i++;
            j = 0;
        }
        else
            j++;

    }

    int noOfQueries, x, y;
    double key;

    inputFile >> noOfQueries;

    for(int i = 1; i <= noOfQueries; i++)
    {
        inputFile >> key;
        findIndices(arr, n, m, key, x, y);
        cout << x << " " << y << endl;
    }

    return 0;
}

