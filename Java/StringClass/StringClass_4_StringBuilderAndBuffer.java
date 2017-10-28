class StringClass_4_StringBuilderAndBuffer
{
	static void concatString(String str)
	{
		str.concat(", the spade and chalic guarding over her gate.");
		/*
		In this method, the string passed from main() is not changed, this is due to the fact that String is immutable. Altering the 
		value of string creates another object and str stores reference of new string. References s1 in main() and concatString() 
		refer to different strings.
		 */
	}
	static void concatStringBuilder(StringBuilder str)
	{
		// StringBuilder is mutable and hence changes its value.
		str.append(", the spade and chalic guarding over her gate.");
	}
	static void concatStringBuffer(StringBuffer str)
	{
		//StringBuffer is similar to StringBuilder except one difference that StringBuffer is thread safe, i.e., multiple threads 
		//can use it without any issue. The thread safety brings a penalty of performance.
		str.append(", the spade and chalic guarding over her gate.");
	}
	public static void main(String args[])
	{
		String str1 = "The Holy Grail beneath the ancient Rosslyn waits";
		StringBuilder str2 = new StringBuilder("The Holy Grail beneath the ancient Rosslyn waits");
		StringBuffer str3 = new StringBuffer("The Holy Grail beneath the ancient Rosslyn waits");
		
		System.out.println("Before Conversion: ");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		
		concatString(str1);
		concatStringBuilder(str2);
		concatStringBuffer(str3);
		
		System.out.println("\nAfter Conversion: ");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
	}
}
