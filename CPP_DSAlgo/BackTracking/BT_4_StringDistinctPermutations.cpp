/*
Given a string that may contain duplicates, write a function to print all permutations of given string such that no permutation is 
repeated in output.
Examples:

Input:  str[] = "AB"
Output: AB BA

Input:  str[] = "AA"
Output: AA

Input:  str[] = "ABC"
Output: ABC ACB BAC BCA CBA CAB

Input:  str[] = "ABA"
Output: ABA AAB BAA

Input:  str[] = "ABCA"
Output: AABC AACB ABAC ABCA ACBA ACAB BAAC BACA 
        BCAA CABA CAAB CBAA
 */
#include <iostream>
#include <map>

using namespace std;

void swap(char & a, char & b)
{
	char temp = a;
	a = b;
	b = temp;
}

void printDistinctPermutations(string str, int index)
{
	int n = str.size();
	map<char, bool> m;
	if(index == n - 1)
	{
		cout << str << " ";
		return;
	}	
	for(int i = index; i < n; i++)
	{
		if(!m[str[i]])
		{
			m[str[i]] = true;
			swap(str[index], str[i]);
			printDistinctPermutations(str, index + 1);
			swap(str[index], str[i]);
		}
	}
}

int main()
{
    string str1 = "AB";
    cout << "Distinct Permutaions of string " << str1 << " are:\n";
    printDistinctPermutations(str1, 0);
    cout << endl;
    
    string str2 = "AA";
    cout << "\nDistinct Permutaions of string " << str2 << " are:\n";
    printDistinctPermutations(str2, 0);
    cout << endl;
    
    string str3 = "ABC";
    cout << "\nDistinct Permutaions of string " << str3 << " are:\n";
    printDistinctPermutations(str3, 0);
    cout << endl;
    
    string str4 = "ABA";
    cout << "\nDistinct Permutaions of string " << str4 << " are:\n";
    printDistinctPermutations(str4, 0);
    cout << endl;
    
    string str5 = "ABCA";
    cout << "\nDistinct Permutaions of string " << str5 << " are:\n";
    printDistinctPermutations(str5, 0);
    cout << endl;
    
    string str6 = "ABCAA";
    cout << "\nDistinct Permutaions of string " << str5 << " are:\n";
    printDistinctPermutations(str6, 0);
    cout << endl;
    
    return 0;
}

