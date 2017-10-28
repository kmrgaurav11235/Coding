/*
 * Search in a row wise and column wise sorted matrix
 * Given an n x n matrix, where every row and column is sorted in increasing order. Given a number x, how to decide whether this x is in 
 * the matrix. The designed algorithm should have linear time complexity. 
 */
import java.util.Arrays;
class Matrix_1_SearchInRowColumnSortedMatrix
{
	static boolean searchInRowColumnSortedMatrix(int a[][], int n, int key)
	{
		int i = 0, j = n - 1;
		while(i < n && j >= 0)
		{
			if(a[i][j] == key)
				return true;
			else if(a[i][j] > key)
				j--;
			else
				i++;
		}
		return false;
	}
	public static void main(String args[])
	{
		int a[][] = { {10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {27, 29, 37, 48},
                    {32, 33, 39, 50},
                  };
		int n = 4;
		int key;
		System.out.println("Given matrix:\n" + Arrays.deepToString(a));
		
		key = 29;
		System.out.println("\nIs element " + key + " present in the matrix: " + searchInRowColumnSortedMatrix(a, n, key));
		
		key = 10;
		System.out.println("\nIs element " + key + " present in the matrix: " + searchInRowColumnSortedMatrix(a, n, key));
		
		key = 31;
		System.out.println("\nIs element " + key + " present in the matrix: " + searchInRowColumnSortedMatrix(a, n, key));
	}
}
