#include <iostream>
#include <string>

using namespace std;

int main()
{
	string binNum;
	long pow = 1;
	long bin = 0;
	cout << "Enter the Binary String: ";
	getline(cin, binNum);
	for (int i = (binNum.size() - 1); i >= 0 ; i--)
	{
		if (binNum[i] == '0' || binNum[i] == '1')
		{
			int currNum = binNum[i] - '0';
			bin = bin + (currNum * pow);
			pow = pow * 2;
		}
		else
		{
			cout << "Not a valid binary string. It must compromise of 0s and 1s only without any whitespaces.\n";
			return 0;
		}
	}
	cout << "Decimal conversion of " << binNum << " is: " << bin << endl;
	return 0;
}
