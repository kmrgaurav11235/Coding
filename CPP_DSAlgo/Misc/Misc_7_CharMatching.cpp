/*
int fun(char **str1, char ***str1){………………}

     A function is given with array of string as input through ” **str1 ” and return output as ” ***str1 “.

     Test case: “Abac Cbaa”—————-> Out put is PASS else FAIL.
     Reasoning: 1)No. of elements after space and before space are equal
				2)Same characters are present before and after space so PASS ( Do not care about case sensitivity).

     Output: **Str1[i]=PASS corresponding to *str1[i] string.

     Solution: traverse array of strings and for each string elements convert either to lower or smaller alphabet. And then EXOR the 
     elements. If left character after Exoring is ” ” (space) then result is PASS.
*/

#include <iostream>
#include <map>

using namespace std;

bool checkPattern(char * str)
{
	map <char, int> m;
	int i, j, k;
	for(i = 0; str[i] != ' '; i++)
	{
		if(str[i] >= 65 && str[i] <= 90)
			m[str[i]]++;
		else if(str[i] >= 97 && str[i] <= 122)
			m[str[i] - 32]++;
	}
	
	k = i;
	i++;
	
	for(j = 0; str[i] != '\0'; j++, i++)
	{		
		if(str[i] >= 65 && str[i] <= 90)
		{
			cout << str[i] << " " <<m[str[i]] << endl;
			if(m[str[i]] <= 0)
				return false;
			else
				m[str[i]]--;
		}
		else if(str[i] >= 97 && str[i] <= 122)
		{
			cout << str[i] << " "  << m[str[i] - 32] << endl;
			if(m[str[i] - 32] <= 0)
				return false;
			else
				m[str[i] - 32]--;
		}
	}
	if(k != j)
		return false;
	
	return true;
}

int main()
{
	char str1[] = "Abac Cbaa";
	cout << checkPattern(str1);
	return 0;
}
