/*
Write a program to print all permutations of a given string. Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB
 */
#include <iostream>

using namespace std;

void swap(char & a, char & b)
{
	char temp = a;
	a = b;
	b = temp;
}

void printAllPermutations(string str, int index)
{
	int n = str.size();
	if(index == n - 1)
	{
		cout << str << " ";
		return;
	}	
	for(int i = index; i < n; i++)
	{
		swap(str[index], str[i]);
		printAllPermutations(str, index + 1);
		swap(str[index], str[i]);
	}
}

int main()
{
    string str = "ABC";
    
    cout << "Permutaions of string " << str << " are:\n";
    printAllPermutations(str, 0);
    return 0;
}
