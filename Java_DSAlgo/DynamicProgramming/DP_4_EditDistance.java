/*
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * 		Insert
 * 		Remove
 * 		Replace
 * 
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’. All of the above operations are of equal cost.
 * 
 * Examples:
 * 
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 * 
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 * 
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically need to convert "un" to "atur".  This can be done using below three operations. 
 * Replace 'n' with 'r', insert t, insert a
 */
import java.util.*;
class DP_4_EditDistance
{
	static int findMin(int a, int b, int c)
	{
		int temp;
		if(a <= b)
			temp = a;
		else
			temp = b;
		if(c < temp)
			temp = c;
		return temp;
	}
	static int findNumberOfOperationsUtil(String str1, String str2, int n, int m, int numOp[][])
	{
		// If first string is empty, the only option is to insert all characters of second string into first
		if(n < 0)
			return (m + 1);
		// If second string is empty, the only option is to remove all characters of first string
		else if(m < 0)
			return (n + 1);
		else if(numOp[n][m] != -1)
			return numOp[n][m];
		int minVal;
		// If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings.
		if(str1.charAt(n) == str2.charAt(m))
		{
			minVal = findNumberOfOperationsUtil(str1, str2, n - 1, m - 1, numOp);
		}
		else
		{
			//If last characters are not same, consider all three operations on last character of first string, recursively compute 
			//minimum cost for all three operations and take minimum of three values.
			minVal = findMin(
							//insert
							1 + findNumberOfOperationsUtil(str1, str2, n, m - 1, numOp),
							//remove
							1 + findNumberOfOperationsUtil(str1, str2, n - 1, m, numOp),
							//replace
							1 + findNumberOfOperationsUtil(str1, str2, n - 1, m - 1, numOp)
						);
		}
		numOp[n][m] = minVal;
		return numOp[n][m];
	}
	static int findNumberOfOperations(String str1, String str2)
	{
		int n = str1.length();
		int m = str2.length();
		
		int numOp[][] = new int[n][m];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(numOp[i], -1);
		
		return findNumberOfOperationsUtil(str1, str2, n - 1, m - 1, numOp);
	}
	public static void main(String args[])
	{
		System.out.println("Edit Distance problem:\n");
		
		String str1 = "geek";
		String str2 = "gesek";		
		System.out.println("Str1: " + str1 + "\nStr2: " + str2);
		System.out.println("Number of Operations: " + findNumberOfOperations(str1, str2));
		
		String str01 = "cat";
		String str02 = "cut";		
		System.out.println("Str01: " + str01 + "\nStr02: " + str02);
		System.out.println("Number of Operations: " + findNumberOfOperations(str01, str02));
		
		String str11 = "sunday";
		String str12 = "saturday";		
		System.out.println("Str1: " + str11 + "\nStr2: " + str12);
		System.out.println("Number of Operations: " + findNumberOfOperations(str11, str12));
		
		String str21 = "lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq";
		String str22 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcaceh";		
		System.out.println("Str1: " + str21 + "\nStr2: " + str22);
		System.out.println("Number of Operations: " + findNumberOfOperations(str21, str22));
	}
}
