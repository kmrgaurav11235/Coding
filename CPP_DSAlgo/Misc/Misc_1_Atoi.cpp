/*
Implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it. If the input 
string is not a numerical string then output will be -1.
*/
#include <iostream>

using namespace std;

long my_atoi(char * c)
{
	char * p = c;
	long res = 0;
	long sign = 1;
	if (*p == '-')
	{
		sign = -1;
		p++;
	}
	while(p != '\0')
	{
		if((*p) < '0' || (*p) > '9')
			return -1;
		res = (10 * res) + ((*p) - '0');
		p++;
	}
	return (res * sign);
}

int main()
{
	char * c;
	cout << "Enter the string: ";
	cin >> c;
	cout << "\nCalling Atoi on " << c << ".";
	long res = my_atoi(c);
	cout << "\nResult: " << res << endl;
    return 0;
}
