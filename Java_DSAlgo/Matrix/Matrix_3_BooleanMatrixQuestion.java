/*
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells 
 * of ith row and jth column as 1.
 * Example 1
 * The matrix
 * 1 0
 * 0 0
 * should be changed to following
 * 1 1
 * 1 0
 * 
 * Example 2
 * The matrix
 * 0 0 0
 * 0 0 1
 * should be changed to following
 * 0 0 1
 * 1 1 1
 * 
 * Example 3
 * The matrix
 * 1 0 0 1
 * 0 0 1 0
 * 0 0 0 0
 * should be changed to following
 * 1 1 1 1
 * 1 1 1 1
 * 1 0 1 1
 */
import java.util.Arrays;
class Matrix_3_BooleanMatrixQuestion
{
	static void modifyBooleanMatrix(int a[][], int n, int m)
	{
		int i, j;
		int row[] = new int[m];
		int col[] = new int[n];
		for(i = 0; i < n; i++)
			for(j = 0; j < m; j++)
				if(a[i][j] == 1)
				{
					row[j] = 1;
					col[i] = 1;
				}
		for(i = 0; i < n; i++)
		{
			for(j = 0; j < m; j++)
			{
				if(row[j] == 1 || col[i] == 1)
					a[i][j] = 1;
			}
		}
	}
	public static void main(String args[])
	{
		int n, m;
		
		int a1[][] = {
					{1, 0},
					{0, 0}			
				};
		n = 2;
		m = 2;
		System.out.println("Given matrix:\n" + Arrays.deepToString(a1));
		modifyBooleanMatrix(a1, n, m);
		System.out.println("Changed matrix:\n" + Arrays.deepToString(a1));
		
		int a2[][] = {
					{0, 0, 0},
					{0, 0, 1}			
				};
		n = 2;
		m = 3;
		System.out.println("\nGiven matrix:\n" + Arrays.deepToString(a2));
		modifyBooleanMatrix(a2, n, m);
		System.out.println("Changed matrix:\n" + Arrays.deepToString(a2));
		
		int a3[][] = {
					{1, 0, 0, 1},
					{0, 0, 1, 0},	
					{0, 0, 0, 0}			
				};
		n = 3;
		m = 4;
		System.out.println("\nGiven matrix:\n" + Arrays.deepToString(a3));
		modifyBooleanMatrix(a3, n, m);
		System.out.println("Changed matrix:\n" + Arrays.deepToString(a3));
		
		int a4[][] = {
					{1, 1, 1, 1},
					{1, 1, 1, 1},
					{1, 0, 1, 1}
				};
		n = 2;
		m = 2;
		System.out.println("\nGiven matrix:\n" + Arrays.deepToString(a4));
		modifyBooleanMatrix(a4, n, m);
		System.out.println("Changed matrix:\n" + Arrays.deepToString(a4));
	}
}
/*
 * Solution:
 * 1) Create two temporary arrays row[M] and col[N]. Initialize all values of row[] and col[] as 0.
 * 2) Traverse the input matrix mat[M][N]. If you see an entry mat[i][j] as true, then mark row[i] and col[j] as true.
 * 3) Traverse the input matrix mat[M][N] again. For each entry mat[i][j], check the values of row[i] and col[j]. If any of the two 
 * 		values (row[i] or col[j]) is true, then mark mat[i][j] as true.
 * 
 * Aliter:
 * This method is a space optimized version of above method. This method uses the first row and first column of the input matrix in place 
 * of the auxiliary arrays row[] and col[] of method 1. So what we do is: first take care of first row and column and store the info 
 * about these two in two flag variables rowFlag and colFlag. Once we have this info, we can use first row and first column as auxiliary 
 * arrays and apply method 1 for submatrix (matrix excluding first row and first column) of size (M-1)*(N-1).
 * 
 * 1) Scan the first row and set a variable rowFlag to indicate whether we need to set all 1s in first row or not.
 * 2) Scan the first column and set a variable colFlag to indicate whether we need to set all 1s in first column or not.
 * 3) Use first row and first column as the auxiliary arrays row[] and col[] respectively, consider the matrix as submatrix starting from 
 * 		second row and second column and apply method 1.
 * 4) Finally, using rowFlag and colFlag, update first row and first column if needed.
 */
