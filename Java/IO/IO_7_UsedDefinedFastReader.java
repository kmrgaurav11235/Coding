/*
 * Create a class to take this input:
 * 7 3       //no_of_integers divisor
 * 1         //numbers
 * 51
 * 966369
 * 7
 * 9
 * 999996
 * 11
 * 
 * Output:
 * 4         //number of integers divisible by divisor
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

class IO_7_UsedDefinedFastReader
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
		double nextDouble()
		{
			return Double.parseDouble(next());
		}
		long nextLong()
		{
			return Long.parseLong(next());
		}
		String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}
	public static void main(String args[])
	{
		FastReader fr = new FastReader();
		
		int num = fr.nextInt();
		int divisor = fr.nextInt();
		int count = 0;
		while(num > 0)
		{
			int dividend = fr.nextInt();
			if(dividend % divisor == 0)
				count++;
			num--;
		}
		System.out.println(count);
	}
}
