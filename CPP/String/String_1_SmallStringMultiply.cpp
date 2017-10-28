//Given two numbers as stings s1 and s2 your task is to multiply them. s1 and s2 and within integer limit
#include <iostream>

using namespace std;

int stringToNum(string str)
{
	int sign = 1;
	int num = 0;
	char * p = (char *)(&str[0]);
	if((*p) == '-')
	{
		sign = -1;
		p++;
	}
	while ((*p) != '\0')
	{
		if((*p) >= '0' && (*p) <= '9')
		{
			num = (10 * num) + ((*p) - '0');
			p++;
		}
		else
		{
			//cout << str << " cannot be converted to integer.\n";
			return 0;
		}
	}
	return (num * sign);
}

string numToString(int num)
{
	string str = "XXXXXXX";
	int dig, max_num;
	char * p = (char *)(&str[0]);
	char * q = p;
	if (num == 0)
		return "0";
	else if(num < 0)
	{
		(*p) = '-';
		p++;
		num = num * (-1);
	}
	max_num = 1;
	
	while ((num / max_num) != 0)
	{
		max_num = max_num * 10;
	}
	max_num = max_num / 10;
	
	while (max_num != 0)
	{
		dig = num / max_num;
		(*p) = (char)(dig + '0');
		p++;
		num = num % max_num;
		max_num = max_num / 10;
	}
	
	(*p) = '\0';
	
	string str1 = (string)q;
	
	return str1;
}
string multiplyStrings(string s1, string s2) 
{
	int num1 = stringToNum(s1);
	int num2 = stringToNum(s2);
	
	int num3 = num1 * num2;
	
	string s3 = numToString(num3);
	return s3;	
}

int main()
{
	string s1 = "400";
	string s2 = "-3";
	
	string s3 = multiplyStrings(s1, s2);
	cout << s1 << " x " << s2 << " = " << s3 << endl;
	
	return 0;
}
