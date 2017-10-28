/*
Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns.
In each turn, a player selects either the first or last coin from the row, removes it from the row permanently,
and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
*/
#include <iostream>

using namespace std;

int findMax(int x, int y)
{
    return ((x >= y)?x:y);
}

int findMin(int x, int y)
{
    return ((x <= y)?x:y);
}

int optimalStrategyOfGame(int a[], int low, int high, int optimalStrategy[][100])
{
    if(optimalStrategy[low][high] != -1)
        return optimalStrategy[low][high];
    else if(low == high)
    {
        optimalStrategy[low][high] = a[low];
        return a[low];
    }
    else if((low + 1) == high)
    {
        optimalStrategy[low][high] = findMax(a[low], a[high]);
        return optimalStrategy[low][high];
    }
    int f1, f2, f3, f4, f5, f6;

    f1 = optimalStrategyOfGame(a, (low + 2), high, optimalStrategy);
    f2 = optimalStrategyOfGame(a, (low + 1), (high - 1), optimalStrategy);
    f3 = optimalStrategyOfGame(a, low, (high - 2), optimalStrategy);

    f4 = findMin(f1, f2);
    f5 = findMin(f2, f3);

    f6 = findMax(a[low] + f4, a[high] + f5);
    optimalStrategy[low][high] = f6;
    return f6;
}

int main()
{
	int a[] = {8, 15, 3, 7};
	int n = 4;

	int optimalStrategy[100][100];
	for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            optimalStrategy[i][j] = -1;

	int totalCoinValue = optimalStrategyOfGame(a, 0, 3, optimalStrategy);

	cout << "Max coin value to be collected is: " << totalCoinValue << endl;

	return 0;
}
/*
Solution:
There are two choices:
1. The user chooses the low coin with value a[low]:
    The opponent either chooses (low+1)th coin or high coin.
    The opponent intends to choose the coin which leaves the user with minimum value.
    i.e. The user can collect the value a[low] + min(F(i+2, j), F(i+1, j-1) )

2. The user chooses the high coin with value A[high]:
    The opponent either chooses low coin or (high-1)th coin.
    The opponent intends to choose the coin which leaves the user with minimum value.
    i.e. The user can collect the value a[high] + min(F(i+1, j-1), F(i, j-2) )
*/
