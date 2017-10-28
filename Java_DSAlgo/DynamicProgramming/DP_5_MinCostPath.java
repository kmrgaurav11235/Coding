/*
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) 
 * from (0, 0). 
 * Each cell of the matrix represents a cost to traverse through that cell. 
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
 * You can only traverse down, right and diagonally lower cells from a given cell, 
 * 		i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 
 * You may assume that all costs are positive integers.
 */
import java.util.Arrays;
class DP_5_MinCostPath
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
	static int findMinCostPathUtil(int a[][], int n, int m, int costPath[][])
	{
		if(n < 0 || m < 0)
			return Integer.MAX_VALUE;
		else if(costPath[n][m] != -1)
			return costPath[n][m];
		
		costPath[n][m] = a[n][m] + findMin(
							findMinCostPathUtil(a, n - 1, m, costPath),
							findMinCostPathUtil(a, n, m - 1, costPath),
							findMinCostPathUtil(a, n - 1, m - 1, costPath)
							);
		
		return costPath[n][m];
	}
	static int findMinCostPath(int a[][], int n, int m)
	{
		int costPath[][] = new int[n + 1][m + 1];
		for(int i = 0; i <= n; i++)
			Arrays.fill(costPath[i], -1);
		costPath[0][0] = a[0][0];
		return findMinCostPathUtil(a, n, m, costPath);
	}
	public static void main(String args[])
	{
		System.out.println("Minimum cost path problem:\n");
		int cost[][] = { {1, 2, 3},
                      {4, 8, 2},
                      {1, 5, 3} };
		System.out.println("Cost Array:\n" + Arrays.deepToString(cost));
		System.out.println("\nMinimum cost from (0, 0) to (2, 2): " + findMinCostPath(cost, 2, 2));
	}
}
/*
 * To reach (m, n) can be written as "minimum of the 3 cells plus cost[m][n]".
 * 		minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
 */
