class StringClass_5_Split
{
	public static void main(String args[])
	{
		String str = "Alone in masters loving art she lies,  she rests at last beneath the starry skies .   ";
		
		//Same as limit = 0
		System.out.println("No delimiter");
		String strArray1[] = str.split(" ");		
		for(String i:strArray1)
		{
			System.out.println(i);
		}
		
		//limit < 0 : In this case, the pattern will be applied as many times as possible, and the resulting array can be of any size.
		System.out.println("\nPositive delimiter");
		String strArray2[] = str.split(" ", 5);		
		for(String i:strArray2)
		{
			System.out.println(i);
		}		
		
		
		/*
		limit > 0 : If this is the case then the pattern will be applied at most limit-1 times, the resulting array’s length will 
		not be more than n, and the resulting array’s last entry will contain all input beyond the last matched pattern.
		*/
		System.out.println("\nNegative delimiter");
		String strArray3[] = str.split(" ", -5);		
		for(String i:strArray3)
		{
			System.out.println(i);
		}
		
		/*
		limit = 0 : In this case, the pattern will be applied as many times as possible, the resulting array can be of any size, 
		and trailing empty strings will be discarded.
		 */
		System.out.println("\nZero delimiter");
		String strArray4[] = str.split(" ", 0);		
		for(String i:strArray4)
		{
			System.out.println(i);
		}
		System.out.println("------End-------");
	}
}
