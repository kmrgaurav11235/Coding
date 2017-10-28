import java.util.Arrays;
class Array_3_ReverseAnArray
{
	static void reverseArray(int a[])
	{
		int n = a.length;
		
		for(int i = 0; i < n/2; i++)
		{
			int temp = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = temp;
		}
	}
	public static void main(String args[])
	{
		int a1[] = {3, 19, -1, 8, 7, 2, 6, 9 , 11};
		int a2[] = {14, 22, 11, 7, 22, 66};
		
		System.out.println("Original Array: " + Arrays.toString(a1));
		reverseArray(a1);
		System.out.println("Reversed Array: " + Arrays.toString(a1));
		
		System.out.println("Original Array: " + Arrays.toString(a2));
		reverseArray(a2);
		System.out.println("Reversed Array: " + Arrays.toString(a2));
	}
}
