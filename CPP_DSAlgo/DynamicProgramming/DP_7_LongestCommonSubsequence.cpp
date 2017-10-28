/*
Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same 
relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
So a string of length n has 2^n different possible subsequences.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

*/

#include <iostream>
#include <string>

using namespace std;

int findMax(int a, int b)
{
	if(a >= b)
		return a;
	else
		return b;
}

int longestCommonSubsequence(string a, string b)
{
	int n = a.size();
	int m = b.size();
	int i, j;
	int lcs[n + 1][m + 1];
	
	for(i = 0; i <= n; i++)
		lcs[i][0] = 0;
	
	for(j = 1; j <= m; j++)
		lcs[0][j] = 0;
	
	for(i = 1; i <= n; i++)
	{
		for(j = 1; j <= m; j++)
		{
			if(a[i - 1] == b[j - 1])
				lcs[i][j] = 1 + lcs[i - 1][j - 1];
			else
				lcs[i][j] = findMax(lcs[i][j - 1],lcs[i - 1][j]);
		}
	}
	
	return lcs[n][m];
}

int main()
{
    string a1 = "ABCDGH";
    string b1 = "AEDFHR";
    
    cout << "For Strings: " << a1 << " and " << b1 << ", ";
    cout << "Length of longest common subsequence is: " << longestCommonSubsequence(a1, b1) << ".\n";
    
    string a2 = "AGGTAB";
    string b2 = "GXTXAYB";
    
    
    cout << "\nFor Strings: " << a2 << " and " << b2 << ", ";
    cout << "Length of longest common subsequence is: " << longestCommonSubsequence(a2, b2) << ".\n";
    
    return 0;
}


