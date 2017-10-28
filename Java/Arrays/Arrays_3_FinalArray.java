class Arrays_3_FinalArray
{
	public static void main(String args[])
	{
		final int arr[] = {15, 67, 90, 67, 62, 0};
		
		System.out.println("Array:");
		for(int i: arr)
		{
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		arr[3] = 9;
		/*
		 * The array arr is declared as final, but the elements of array are changed without any problem. Arrays are objects and object 
		 * variables are always references in Java. So, when we declare an object variable as final, it means that the variable cannot 
		 * be changed to refer to anything else.
		 */
		
		System.out.println("Array after change:");
		for(int i: arr)
		{
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		/*
		 * This will give error as arr is final. A final array means that the array variable which is actually a reference to an 
		 * object, cannot be changed to refer to anything else, but the members of array can be modified.
		 */
		//arr = new int[]{17, 11, 19, 77};
	}
}
