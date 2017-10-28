class Arrays_1_Default
{
	public static void main(String args[])
	{
		//Unlike C++, in java, arrays are container objects.
		/*
		If we don’t assign values to array elements, and try to access them, compiler does not produce error as in case of simple 
		variables. Instead it assigns values which aren’t garbage. Below are the default assigned values.
			boolean : false
		    int : 0
		    double : 0.0
		    String : null
		    User Defined Type : null

		 */
		int intArr[] = new int[5];
		double dubArr[] = new double[5];
		char charArr[] = new char[5];
		boolean boolArr[] = new boolean[5];
		String strArr[] = new String[5];
		Arrays_1_Default userDefArr[] = new Arrays_1_Default[5];
		
		System.out.println("Integer Array Default Values:");
		for(int i: intArr)
		{
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		System.out.println("Double Array Default Values:");
		for(double dub: dubArr)
		{
			System.out.print(dub + " ");
		}
		System.out.println("\n");
		
		System.out.println("Character Array Default Values:");
		for(char ch: charArr)
		{
			System.out.print(ch + " ");
		}
		System.out.println("\n");
		
		System.out.println("Boolean Array Default Values:");
		for(boolean bo: boolArr)
		{
			System.out.print(bo + " ");
		}
		System.out.println("\n");
		
		System.out.println("String Array Default Values:");
		for(String str: strArr)
		{
			System.out.print(str + " ");
		}
		System.out.println("\n");
		
		System.out.println("User-Defined Object Array Default Values:");
		for(Arrays_1_Default udo: userDefArr)
		{
			System.out.print(udo + " ");
		}
		System.out.println("\n");
	}
}
