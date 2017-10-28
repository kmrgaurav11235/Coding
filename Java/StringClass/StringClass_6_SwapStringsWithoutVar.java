class StringClass_6_SwapStringsWithoutVar
{
	public static void main(String args[])
	{
		String str1 = "One ring to rule them all.";
		String str2 = "One ring to find them.";
		
		System.out.println("Before Swap:");
		System.out.println("String 1: " + str1);
		System.out.println("String 2: " + str2);
		
		str1 = str1.concat(str2);
		str2 = str1.substring(0, str1.length() - str2.length());
		str1 = str1.substring(str2.length());
		
		System.out.println("\nAfter Swap:");
		System.out.println("String 1: " + str1);
		System.out.println("String 2: " + str2);
	}
}
