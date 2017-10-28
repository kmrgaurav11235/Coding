import java.util.*;
import java.io.*;
class DP_1_Fibonacci
{
	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;
		FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next()
		{
			try
			{
				while(st == null || !st.hasMoreTokens())
				{
					st = new StringTokenizer(br.readLine());
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return st.nextToken();
		}
		int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
	static int calulateFibonacci(int n)
	{
		int fib[] = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i <= n; i++)
		{
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
	public static void main(String args[])
	{
		System.out.println("Fibonacci caloculator.\nEnter number from 1 to 100:");
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		if(n > 100 || n < 1)
			System.out.println("Invalid value of n.");
		else
		{
			System.out.println("Fibonacci number with index " + n + ": " + calulateFibonacci(n));
		}
	}
}
