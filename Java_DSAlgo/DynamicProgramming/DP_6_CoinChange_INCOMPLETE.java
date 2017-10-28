/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? 
 * 
 * The order of coins doesn’t matter. 
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
import java.util.*;
class DP_6_CoinChange
{
	static int findNumberOfWaysOfCoinChangeUtil(int coins[], int m, int n, int coinChange[])
	{
		//Coin Value Negative
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else if(n != 0 && m < 0)
			return 0;
		else if(coinChange[n] != -1)
			return coinChange[n];
		
		int noOfWays = 0;
		
		for(int i = m; i >= 0; i--)
		{
			noOfWays = noOfWays + findNumberOfWaysOfCoinChangeUtil(coins, i - 1, n, coinChange) 
							+ findNumberOfWaysOfCoinChangeUtil(coins, i, n - coins[i], coinChange);
		}
		coinChange[n] = noOfWays;
		return coinChange[n];
	}
	static int findNumberOfWaysOfCoinChange(int coins[], int n)
	{
		int coinChange[] = new int[n + 1];
		int m = coins.length;
		Arrays.fill(coinChange, -1);
		coinChange[0] = 1;
		return findNumberOfWaysOfCoinChangeUtil(coins, m - 1, n, coinChange);
	}
	public static void main(String args[])
	{
		System.out.println("Coin Change problem:\n");
		
		int a1[] = {1, 2, 3};
		int n1 = 4;
		System.out.println("Coins Avaliable:\n" + Arrays.toString(a1));
		System.out.println("N: " + n1);
		System.out.println("\nNumber of ways to change coins: " + findNumberOfWaysOfCoinChange(a1, n1));
		
		int a2[] = {2, 5, 3, 6};
		int n2 = 10;
		System.out.println("Coins Avaliable:\n" + Arrays.toString(a2));
		System.out.println("N: " + n2);
		System.out.println("\nNumber of ways to change coins: " + findNumberOfWaysOfCoinChange(a2, n2));
	}
}

