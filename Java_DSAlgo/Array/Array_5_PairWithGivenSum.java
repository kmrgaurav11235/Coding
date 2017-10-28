import java.util.HashSet;
import java.util.Arrays;
class Array_5_PairWithGivenSum
{
	static void findParinWithGivenSum(int a[], int sum)
	{
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < a.length; i++)
		{
			if(hs.contains(sum - a[i]) && (!hs.contains(a[i])))
			{
				System.out.println("[" + (sum - a[i]) + ", " + a[i] + "]");
			}
			hs.add(a[i]);
		}
	}
	public static void main(String args[])
	{
		int a[] = {1, 24, 45, 6, 10, -8, 24};
		int sum = 16;
		System.out.println("Array: " + Arrays.toString(a));
		System.out.println("Given Sum = " + sum);
		System.out.println("Pairs with given Sum: ");
		findParinWithGivenSum(a, sum);
	}
}

