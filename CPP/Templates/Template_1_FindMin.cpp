#include <iostream>

using namespace std;

template <class T>
T findMin(T a, T b)
{
	return ((a < b)?a:b);
}

int main()
{
	int a = 5, b = 15;
	cout << "Min (" << a << ", " << b << ") = " << findMin(a, b) << "." << endl;
	
	float p = 5.1, q = -11.91;
	cout << "Min (" << p << ", " << q << ") = " << findMin(p, q) << "." << endl;
	
	double x = 0, y = -15.12111;
	cout << "Min (" << x << ", " << y << ") = " << findMin(x, y) << "." << endl;
	
	return 0;
}
