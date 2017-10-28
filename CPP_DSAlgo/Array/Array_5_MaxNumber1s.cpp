/*
Given an array. Each row of the array consists of 1s and 0s such that all the 1s come before any 0s. Write an efficient algo to return 
the row number that contains the most 1s.

Test cases:
1 -> 0

00
10 -> 1
*/

#include<iostream>
#define MAX 100

using namespace std;

int maxOnes(int a[][MAX], int m, int n)
{
    int curr_indx = 0, curr_max = 0;
    int i;

    for(i = 0; i < n; i++)
    {
        if(a[0][i] == 1)
            curr_max++;
        else
            break;
    }

    for(i = 1; i < m; i++)
    {
        while(curr_max <= n)
        {
            if(curr_max == n)
                return curr_indx;
            else if(a[i][curr_max] == 1)
            {
                curr_indx = i;
                curr_max++;
            }
            else
                break;
        }
    }
    return curr_indx;
}

void displayArray(int a[][MAX], int m, int n)
{
    for(int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
            cout << a[i][j] << " ";
        cout << endl;
    }
}

int main()
{
    int a[MAX][MAX];
    int indx;

    a[0][0] = 1;
    cout << "\nIn Array:\n";
    displayArray(a, 1, 1);
    cout << "Index with Maximum number of 1s = " << maxOnes(a, 1, 1) << endl;

    a[0][0] = 0; a[0][1] = 0; a[1][0] = 1; a[1][1] = 0;
    cout << "\nIn Array:\n";
    displayArray(a, 2, 2);
    cout << "Index with Maximum number of 1s = " << maxOnes(a, 2, 2) << endl;

    a[0][0] = 1; a[0][1] = 0; a[0][2] = 0; a[0][3] = 0;
    a[1][0] = 1; a[1][1] = 1; a[1][2] = 0; a[1][3] = 0;
    a[2][0] = 1; a[2][1] = 1; a[2][2] = 1; a[2][3] = 1;
    a[3][0] = 0; a[3][1] = 0; a[3][2] = 0; a[3][3] = 0;
    a[4][0] = 1; a[4][1] = 1; a[4][2] = 1; a[4][3] = 0;
    cout << "\nIn Array:\n";
    displayArray(a, 5, 4);
    cout << "Index with Maximum number of 1s = " << maxOnes(a, 5, 4) << endl;

    return 0;
}
