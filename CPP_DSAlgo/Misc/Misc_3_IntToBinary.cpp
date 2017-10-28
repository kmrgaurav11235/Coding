#include <iostream>
#include <string>

using namespace std;

string reverseString(string str)
{
	int firstIndex = 0;
	int lastIndex = str.size() - 1;
	while (firstIndex < lastIndex)
	{
		char temp = str[firstIndex];
		str[firstIndex] = str[lastIndex];
		str[lastIndex] = temp;
		firstIndex++;
		lastIndex--;
	}
	return str;
}

int main()
{
	string binNum;
	int intNum, temp;
	char mod;
	cout << "Enter the Integer: ";
	cin >> intNum;
	temp = intNum;
	while(temp > 1)
	{
		mod = '0' + (temp % 2);
		temp = temp / 2;
		binNum = binNum + mod;
	}
	mod = '0' + temp;
	binNum = binNum + mod;
	binNum = reverseString(binNum);
	cout << "Binay conversion of " << intNum << " is: " << binNum << endl;
	return 0;
}
