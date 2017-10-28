//Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a^2 + b^2 = c^2.

#include<iostream>
#include<cmath>

using namespace std;

void swapNum(int &x, int &y)
{
    int temp = x;
    x = y;
    y = temp;
}

void bubbleSort(int a[], int n)
{
    int exchange, i, j;

    for(i = 0; i < n - 1; i++)
    {
        exchange = 0;
        for(j = 0; j < n - i - 1; j++)
        {
            if(a[j] > a[j + 1])
            {
                swapNum(a[j], a[j + 1]);
                exchange++;
            }
        }
        if(exchange == 0)
            break;
    }
}

bool findPythagoreanTriplets(int a[], int n, int &x, int &y, int &z)
{
    int i, l, h;

    for(i = 0; i < n; i++)
        a[i] = a[i] * a[i];

    bubbleSort(a, n);

    for(i = 2; i < n; i++)
    {
        l = 0;
        h = i - 1;

        while(l < h)
        {
            if(a[l] + a[h] == a[i])
            {
                x = sqrt(a[l]);
                y = sqrt(a[h]);
                z = sqrt(a[i]);
                return true;
            }
            else if(a[l] + a[h] > a[i])
                h--;
            else
                l++;
        }
    }
    return false;
}

int main()
{
    int n = 6;
    int a[] = {1, 3, 45, 2, 4, 8};
    int x = -1, y = -1, z = -1;

    cout << "In Array:\n";
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    if(findPythagoreanTriplets(a, n, x, y, z))
        cout <<"\nPythagorean Triplets were found: (" << x << ", " << y << ", " << z << ").\n";
    else
        cout << "\nPythagorean Triplets were not found.\n";
    return 0;
}
