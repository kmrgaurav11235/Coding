/*
 * Given a 2D array, print it in spiral form. See the following examples.
 * Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
 * Output: 
		1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
 * 
 * Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
 * Output: 
		1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */
import java.util.Arrays;
class Matrix_2_SpiralForm
{
	static void printSpiralForm(int a[][], int n, int m)
	{
		int i, j, k = 0;
		int loopCounter = 0;
		
		while(true)
		{
			//Top Row j increases -> [loopCounter, m - loopCounter[
			for(i = loopCounter, j = loopCounter ; j < m - loopCounter; j++, k++)
				System.out.print(a[i][j] + " ");
			if(k >= n * m)
				break;
			
			//Right Column i increases -> ]loopCounter, n - loopCounter[
			for(i = loopCounter + 1, j = m - loopCounter - 1; i < n - loopCounter; i++, k++)
				System.out.print(a[i][j] + " ");
			if(k >= n * m)
				break;
			
			//Bottom Row j decreases -> ]m - loopCounter - 1, loopCounter]
			for(i = n - loopCounter - 1, j = m - loopCounter - 2; j >= loopCounter; j--, k++)
				System.out.print(a[i][j] + " ");
			if(k >= n * m)
				break;
			
			//Left Column i decreases -> ]n - loopCounter - 1, loopCounter[
			for(i = n - loopCounter - 2, j = loopCounter; i > loopCounter; i--, k++)
				System.out.print(a[i][j] + " ");
			loopCounter++;
			if(k >= n * m)
				break;
		}
	}
	public static void main(String args[])
	{
		int n, m;
		
		int a1[][] = {
					{1,    2,   3,   4},
					{5,    6,   7,   8},
					{9,   10,  11,  12},
					{13,  14,  15,  16}			
				};
		n = 4;
		m = 4;
		System.out.println("Given matrix:\n" + Arrays.deepToString(a1) + "\nSpiral Form: ");
		printSpiralForm(a1, n, m);
		
		int a2[][] = {
					{1,   2,   3,   4,  5,   6},
					{7,   8,   9,  10,  11,  12},
					{13,  14,  15, 16,  17,  18}			
				};
		n = 3;
		m = 6;
		System.out.println("\nGiven matrix:\n" + Arrays.deepToString(a2) + "\nSpiral Form: ");
		printSpiralForm(a2, n, m);
	}
}
