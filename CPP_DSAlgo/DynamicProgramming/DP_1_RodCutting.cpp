#include <iostream>
#include <climits>
using namespace std;

int find_max(int a, int b)
{
	if(a >= b)
		return a;
	return b;
}

int rod_cutter_simple (int * p, int n)
{
	int max_price = INT_MIN;
	if (n == 0)
		return 0;
	for (int i = 1; i <= n; i++)
	{
		max_price = find_max(max_price, p[i] + rod_cutter_simple(p, n-i) );
	}
	return max_price;
}

int main()
{
	/*int n = 4;//length of rod
	int p[] = {0, 1, 5, 8, 9};//price array
	*/
	int n;
    cout << "Rod Cutting Problem.\nEnter Length of Rod." << endl;
    cin >> n;
    int p[n+1];
    p[0] = 0;
    cout << "\nEnter Array";
    for (int i = 1; i <= n; i++)
    {
        cout << "\nPrice of Piece of Length " << i << " = ";
        cin >> p[i];
    }
	int max_price = rod_cutter_simple(p, n);
	cout << "Max Price Possible = " << max_price << endl;
	return 0;
}
