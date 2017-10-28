import java.util.*;
/*
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all 
 * elements of the subsequence are sorted in increasing order. For example:
 * The length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * More Examples:
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 * 
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 * 
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 */
class DP_2_LongestIncreasingSubsequence
{
	static int findLongestIncreasingSubsequenceUtil(int a[], int n, int lis[])
	{
		if(lis[n] != 0)
			return lis[n];
		int i;
		int maxVal = 1;
		for(i = 0; i < n; i++)
		{
			int currentVal = findLongestIncreasingSubsequenceUtil(a, i, lis) + 1;
			if(a[i] >= a[n])
			{
				currentVal = 1;
			}
			if(maxVal < currentVal)
				maxVal = currentVal;
		}//end of for
		lis[n] = maxVal;
		return lis[n];
	}
	static int findLongestIncreasingSubsequence(int a[])
	{
		int n = a.length;
		int lis[] = new int[n];
		lis[0] = 1;
		
		findLongestIncreasingSubsequenceUtil(a, n - 1, lis);
		int maxLIS = 1;
		
		for(int i = 0; i < n; i++)
			if(maxLIS < lis[i])
				maxLIS = lis[i];
		return maxLIS;
	}
	public static void main(String args[])
	{
		int a1[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int a2[] = {3, 10, 2, 1, 20};
		int a3[] = {3, 2};
		int a4[] = {50, 3, 10, 7, 40, 80};
		int a5[] = {62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22};
		
		System.out.println("Longest Increasing Subsequence (LIS) problem:\n");
		
		System.out.println("Array:\n" + Arrays.toString(a1));
		System.out.println("Length of LIS: " + findLongestIncreasingSubsequence(a1));
		
		System.out.println("\nArray:\n" + Arrays.toString(a2));
		System.out.println("Length of LIS: " + findLongestIncreasingSubsequence(a2));
		
		System.out.println("\nArray:\n" + Arrays.toString(a3));
		System.out.println("Length of LIS: " + findLongestIncreasingSubsequence(a3));
		
		System.out.println("\nArray:\n" + Arrays.toString(a4));
		System.out.println("Length of LIS: " + findLongestIncreasingSubsequence(a4));
		
		System.out.println("\nArray:\n" + Arrays.toString(a5));
		System.out.println("Length of LIS: " + findLongestIncreasingSubsequence(a5));
	}
}
/*
 * Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
 * Then, L(i) can be recursively written as:
 * 		L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * 		L(i) = 1, if no such j exists.
 * To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
 */
