//Given an array A[] and a number x, check for pair in A[] with sum as x

#include<iostream>
#include<map>

using namespace std;

void findSumUsingMap(int a[], int n, int sum, int &x, int &y)
{
    map<int, int> m;
    for(int i = 0; i < n; i++)
    {
        if(m[sum - a[i]])
        {
            x = i;
            y = m[sum - a[i]] - 1;
            return;
        }
        else
        {
            m[a[i]] = i + 1;//Cannot Use i because 0 is also an index
        }
    }
}

int main()
{
    int n = 6;
    int a[] = {1, 4, 45, 6, 10, -8};
    int sum = 3;
    int x = -1, y = -1;
    findSumUsingMap(a, n, sum, x, y);
    cout << "In Array:\n";
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    if(x == -1 && y == -1)
        cout <<"\nSum " << sum << " was not found.\n";
    else
        cout << "\nSum " << sum << " can be found at:\na[" << x << "] = "
                << a[x] << "\n    +\n" << "a[" << y << "] = " << a[y] << endl;
    return 0;
}
