/*
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a 
 * sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, 
 * ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
 * 
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), 
 * and has applications in bioinformatics.
 * 
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
import java.util.*;
class DP_3_LongestCommonSubsequence
{
	static int findMax(int a, int b)
	{
		if(a >= b)
			return a;
		else
			return b;
	}
	static int findLongestCommonSubsequenceUtil(String str1, String str2, int n, int m, int lcs[][])
	{
		if(n < 0 || m < 0)
			return 0;
		else if(lcs[n][m] != -1)
			return lcs[n][m];
		
		int maxLCS = 0;
		
		if(str1.charAt(n) == str2.charAt(m))
		{
			maxLCS = 1 + findLongestCommonSubsequenceUtil(str1, str2, n - 1, m - 1, lcs);
		}
		else
		{
			maxLCS = findMax(
							findLongestCommonSubsequenceUtil(str1, str2, n - 1, m, lcs), 
							findLongestCommonSubsequenceUtil(str1, str2, n, m - 1, lcs)
						);
		}
		
		lcs[n][m] = maxLCS;
		return lcs[n][m];
	}
	static int findLongestCommonSubsequence(String str1, String str2)
	{
		int n = str1.length();
		int m = str2.length();
		
		int lcs[][] = new int[n][m];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(lcs[i], -1);
		
		return findLongestCommonSubsequenceUtil(str1, str2, n - 1, m - 1, lcs);
	}
	public static void main(String args[])
	{
		System.out.println("Longest Common Subsequence (LIS) problem:\n");
		
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";		
		System.out.println("Str1: " + str1 + "\nStr2: " + str2);
		System.out.println("Length of LCS: " + findLongestCommonSubsequence(str1, str2));
		
		String str01 = "AGGTAB";
		String str02 = "GXTXAYB";		
		System.out.println("Str01: " + str01 + "\nStr02: " + str02);
		System.out.println("Length of LCS: " + findLongestCommonSubsequence(str01, str02));
	}
}
/*
 * If last characters of both sequences match (or X[m-1] == Y[n-1]) then
 * 		L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
 * 
 * If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
 * 		L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])
 */
