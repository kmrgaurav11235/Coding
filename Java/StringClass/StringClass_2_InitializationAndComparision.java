class StringClass_2_InitializationAndComparision
{
	public static void main(String args[])
	{
		/*
		Direct Initialization(String Constant) : In this method, a String constant object will be created in String pooled area which 
		is inside heap area in memory. As it is a constant, we can’t modify it,i.e. String class is immutable.
		 */
		String str1 = "Wit beyond measure";
		String str2 = "Wit beyond measure";
		//str1 = "geeks"; 
		/*This statement will make str1 point to new String constant("geeks") rather then modifying the previous String constant.
		If we again write str1 = "Wit beyond measure" as next line, then it first check that if given String constant is present in String 
		pooled area or not. If it present then str1 will point to it, otherwise creates a new String constant. 
		*/
		
		/*
		Object Initialization (Dynamic): In this method, a String object will be created in heap area (not inside String pooled 
		area as in above case). We can modify it.Also with same value,a String constant is also created in String pooled area,but 
		the variable will point to String object in heap area only.
		 */
		String str3 = new String("Wit beyond measure");
		String str4 = new String("Wit beyond measure");		
		String str5 = "is a man's greatest treasure.";		
		
		System.out.println("String str1 = \"Wit beyond measure\";");
		System.out.println("String str2 = \"Wit beyond measure\";");
		System.out.println("String str3 = new String(\"Wit beyond measure\");");
		System.out.println("String str4 = new String(\"Wit beyond measure\");");		
		System.out.println("String str5 = \"is a man's greatest treasure.\";");
		
		/*
		Comparing Strings and their References:
		-> 1. equals() method: It compares values of string for equality. Return type is boolean. In almost all the situation you 
		can use useObjects.equals().
		
		-> 2. == operator: It compares references not values. Return type is boolean. == is used in rare situations where you 
		know you’re dealing with interned strings.
		 */
		
		System.out.println("\nComapring using equals method:");
		if(str1.equals(str2))
			System.out.println("str1 Equals str2");
		else
			System.out.println("str1 Not Equals str2");
		
		if(str1.equals(str3))
			System.out.println("str1 Equals str3");
		else
			System.out.println("str1 Not Equals str3");
		
		if(str3.equals(str4))
			System.out.println("str3 Equals str4");
		else
			System.out.println("str3 Not Equals str4");
		
		if(str1.equals(str5))
			System.out.println("str1 Equals str5");
		else
			System.out.println("str1 Not Equals str5");
		
		System.out.println("\nComapring using == operator:");
		if(str1 == str2)
			System.out.println("str1 Equals str2");
		else
			System.out.println("str1 Not Equals str2");
		
		if(str1 == str3)
			System.out.println("str1 Equals str3");
		else
			System.out.println("str1 Not Equals str3");
		
		if(str3 == str4)
			System.out.println("str3 Equals str4");
		else
			System.out.println("str3 Not Equals str4");
		
		if(str1 == str5)
			System.out.println("str1 Equals str5");
		else
			System.out.println("str1 Not Equals str5");
	}
}
