/*
Given NXN matrix filled with 1,0,2,3.
1(Source)
2(Destination)
3(Blank cell)
0(wall)
Write a code to identify whether there is a path possible from source to destination, traversing through blank cells only.
You can traverse up, down, right and left.
*/
#include <iostream>
#define MAX 100

using namespace std;

bool isPathPossible(int a[][MAX], int n, char dirOfArrival, int x, int y, int work[][MAX])
{
    if(a[x][y] == 2)
        return true;
    else if(a[x][y] == 0 || a[x][y] == 1)
        return false;
    else if(work[x][y] == 1)
        return false;
    work[x][y] = 1;

    if(dirOfArrival != 'U' && (x - 1 >= 0) && isPathPossible(a, n, 'D', x-1, y, work))
        return true;
    else if(dirOfArrival != 'D' && (x + 1 < n) && isPathPossible(a, n, 'U', x+1, y, work))
        return true;
    else if(dirOfArrival != 'L' && (y - 1 >= 0) && isPathPossible(a, n, 'R', x, y-1, work))
        return true;
    else if(dirOfArrival != 'R' && (y + 1 < 0) && isPathPossible(a, n, 'L', x, y+1, work))
        return true;
    return false;
}

int main()
{
    int a[MAX][MAX], work[MAX][MAX];
    int n, x, y;
    bool isSourceSet = false, isDestSet = false;
    cout << "Enter dimension n (<= 100)";
    cin >> n;
    if (n > 100 || n < 1){
        cout << "\nInvalid Dimension.\n";
        return 0;
    }
    cout << "\nEnter Array: \n1(Source)\n2(Destination)\n3(Blank cell)\n0(wall)\n";
    for (int i = 0; i < n; i ++)
    {
        for(int j = 0; j < n ; j++)
        {
            cout << "\nEnter Element a[" << i << "][" << j <<"]: ";
            cin >> a[i][j];
            if (a[i][j] > 3 || a[i][j] < 0){
                cout << "\nInvalid Input.\n";
                return 0;
            }
            else if(a[i][j] == 2){
                if(isDestSet){
                    cout << "\nMultiple destinations are not allowed.\n";
                    return 0;
                }
                else{
                    x = i;
                    y = j;
                    isDestSet = true;
                }
            }
            else if(a[i][j] == 1){
                if(isSourceSet){
                    cout << "\nMultiple sources are not allowed.\n";
                    return 0;
                }
                else{
                    isSourceSet = true;
                }
            }
            work[i][j] = 0;
        }
    }



    bool res = isPathPossible(a, n, 'X', x, y, work);
    if (res)
        cout << "\nPath is possible from Source to Destination.\n";
    else
        cout << "\nPath is not possible from Source to Destination.\n";
    return 0;
}
