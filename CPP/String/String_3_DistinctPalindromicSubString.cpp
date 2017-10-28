//Find all distinct palindromic sub-strings of a given string
#include <iostream>
#include <string>
#include <map>

using namespace std;

void findDistinctPalindromicSubString(string inputString)
{
	string boundedString = "@" + inputString + "#";
	int lastIndx = boundedString.size() - 2;
	int palindromeRadius[lastIndx][2];//Index [0][] and [MAX][] will not be utilized
	int left, right;
	
	map<string, int> m;
	
	for (int i = 1; i <= lastIndx; i++)
	{
		//Odd Length: aba
		palindromeRadius[i][0] = 1;
		m[boundedString.substr(i, 1)] = 1;
		left = i - 1;
		right = i + 1;
		while(boundedString[left] == boundedString[right])
		{
			palindromeRadius[i][0]++;
			m[boundedString.substr(left, right - left + 1)] = 1;			
			left--;
			right++;
		}
		
		//Even Length: abba
		palindromeRadius[i][1] = 0;
		left = i;
		right = i + 1;
		while(boundedString[left] == boundedString[right])
		{
			palindromeRadius[i][1]++;
			m[boundedString.substr(left, right - left + 1)] = 1;	
			left--;
			right++;
		}		
	}
	/*
	cout << "Array palindromeRadius:\n";
	for(int i = 1; i <= lastIndx; i++)
		cout << palindromeRadius[i][0] << "  " << palindromeRadius[i][1] << endl;
	*/
	map<string, int>::iterator mi;
	for (mi = m.begin(); mi!=m.end(); mi++)
		  cout << (*mi).first << endl;
	
}

int main()
{
	string inputString;
	cout << "Enter input string: ";
	getline(cin, inputString);
	findDistinctPalindromicSubString(inputString);
	return 0;
}
