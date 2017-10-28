#include <iostream>
#include <climits>

using namespace std;

int find_max(int a, int b)
{
	if (a >= b)
		return a;
	return b;
}

int rod_cutter_bottomup(int * p, int n, int * max_price_array)
{
	if (n == 0)
		return 0;
	else
	{
		for (int i = 1; i <= n; i++)
		{
			int max_price = INT_MIN;
			for (int j = 1; j <= i; j++)
			{
				max_price = find_max(max_price, p[j] + max_price_array[i-j]);
			}
			max_price_array[i] = max_price;
		}
		return max_price_array[n];
	}
}

int main()
{
	int n = 10;//length of rod
	int p[] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 26};//price array
	/*
	int n;
    cout << "Rod Cutting Problem: Bottom-Up.\nEnter Length of Rod." << endl;
    cin >> n;
    int p[n+1];
    p[0] = 0;
    cout << "\nEnter Array";
    for (int i = 1; i <= n; i++)
    {
        cout << "\nPrice of Piece of Length " << i << " = ";
        cin >> p[i];
    }
    */
    int max_price_array[n+1];
    max_price_array[0] = 0;
	int max_price = rod_cutter_bottomup(p, n, max_price_array);
	cout << "Max Price Possible = " << max_price << endl;
	cout << "\nMax Price Array:\n";
    for (int i = 1; i <= n; i++)
    {
        cout << "Max Price for Rod of Length " << i << " = " << max_price_array[i] << endl;
    }
	return 0;
}
