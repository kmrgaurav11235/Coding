#include <iostream>

using namespace std;

template <class T>
void mySwap(T & a, T & b)
{
	T c;
	c = a;
	a = b;
	b = c;
}

int main()
{
	int a = 5, b = 15;
	cout << "Initial: Num1 = " << a << ", Num2 = " << b << "." << endl;
	mySwap(a, b);
	cout << "After Swap: Num1 = " << a << ", Num2 = " << b << ".\n" << endl;
	
	float p = 5.1, q = -11.91;
	cout << "Initial: Num1 = " << p << ", Num2 = " << q << "." << endl;
	mySwap(p, q);
	cout << "After Swap: Num1 = " << p << ", Num2 = " << q << ".\n" << endl;
	
	double x = 0, y = -15.12111;
	cout << "Initial: Num1 = " << x << ", Num2 = " << y << "." << endl;
	mySwap(x, y);
	cout << "After Swap: Num1 = " << x << ", Num2 = " << y << "." << endl;
	
	return 0;
}

