//Given two non-negative integers as stings s1 and s2 your task is to multiply them.
#include <iostream>
#include <string>

using namespace std;

string multiplyStrings(string s1, string s2) 
{
	int size_s1 = s1.size();
	int size_s2 = s2.size();
	
	string s3;
	
	if(size_s1 == 0 || size_s2 ==  0)
	{
		s3 = "0";
		return s3;
	}
	
	int result[size_s1 + size_s2];//store the result in reverse
	int i, j;
	
	for(i = 0; i < (size_s1 + size_s2); i++)
		result[i] = 0;
		
	int indx_s1 = 0, indx_s2 = 0;
	
	int n_s1 = 0, n_s2 = 0;
	int product;
	int carry = 0;
	
	for(i = (size_s1 - 1); i >= 0; i--)
	{
		n_s1 = s1[i] - '0';
		indx_s2 = 0;
		carry = 0;
		for(j = (size_s2 - 1); j >= 0; j--)
		{
			n_s2 = s2[j] - '0';
			product = (n_s1 * n_s2) + carry + result[indx_s1 + indx_s2];
			carry = product / 10;
			result[indx_s1 + indx_s2] = product % 10;
			
			indx_s2++;
		}
		if (carry > 0)
			result[indx_s1 + indx_s2] = result[indx_s1 + indx_s2] + carry;
		indx_s1++;
	}
	
	int indx_result = size_s1 + size_s2 - 1;
	while(indx_result >= 0 && result[indx_result] == 0)
		indx_result--;
		
	if(indx_result == -1)
		s3 = "0";
	else
	{
		while(indx_result >= 0)
		{
			s3 = s3 + std::to_string(result[indx_result]);//This can be used in new compilers only
			indx_result--;
		}
	}
	
	return s3;
}

int main()
{
	string s1 = "400";
	string s2 = "3";
	
	string s3 = multiplyStrings(s1, s2);
	cout << s1 << " x " << s2 << " = " << s3 << endl;
	
	return 0;
}
