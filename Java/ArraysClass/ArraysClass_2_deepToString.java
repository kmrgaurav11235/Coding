import java.util.Arrays;
class ArraysClass_2_deepToString
{
	public static void main(String args[])
	{
		int n = 5;
		int a[][] = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				a[i][j] = i + j + 1;
		
		/*
		 * public static String deepToString(Object[] arr)
		 * 		-> arr - An array whose string representation is needed
		 * 		-> This function returns string representation of arr[]. It returns "null"   if the specified array is null.
		 * Returns a string representation of the "deep contents" of the specified array. If the array contains other arrays as 
		 * elements, the string representation contains their contents and so on. This method is designed for converting 
		 * multidimensional arrays to strings. The simple toString() method works well for simple arrays, but doesn’t work for 
		 * multidimensional arrays. This method is designed for converting multi-dimensional arrays to strings.
		 */
		
		System.out.println("Array printed using toString:");
		System.out.println(Arrays.toString(a));
		
		System.out.println("\nArray printed using deepToString:");
		System.out.println(Arrays.deepToString(a));		
		
		System.out.println("\nCorrect way to print Array using toString:");
		for(int b[]:a)
			System.out.println(Arrays.toString(b));
		
		/*
		 * deepToString() works for both single and multidimensional arrays of Objects, but doesn’t work single dimensional array 
		 * of primitives
		 */
		//int b[] = {10, 20, 30, 40};
        //System.out.println(Arrays.deepToString(b));
	}
}
