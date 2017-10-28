class StringClass_1_StringMethods
{
	public static void main(String args[])
	{
		String str1 = "I love tuna and tuna loves me.";
		System.out.println("String: " + str1);
		
		int len = str1.length();
		System.out.println("Length = " + len);
		
		char ch = str1.charAt(4);		
		//char ch = str1[4]; <- This cannot be used
		System.out.println("\nChar at Index 4 = " + ch);
		
		//no camel case in substring
		System.out.println("\nSubstring starting at Index 16 = " + str1.substring(16));
		System.out.println("Substring starting at Index 2 and ending before Index 6 = " + str1.substring(2, 6));
		
		System.out.println("\nFirst Index of love = " + str1.indexOf("love"));
		System.out.println("Last Index of love = " + str1.lastIndexOf("love"));
		System.out.println("First Index of tuna starting from Index 11 = " + str1.indexOf("tuna", 11));
		
		String str2 = str1.concat(" I feel happy.");
		System.out.println("\nConcatenation = " + str2);
		
		String str3 = "Tribune";
		String str4 = "Tribune";
		String str5 = "Pleb";
		String str6 = "tRiBuNe";
		if(str3.equals(str4))
			System.out.println("\n" + str3 + " Equals " + str4 + ".");
		else
			System.out.println("\n" + str3 + " Not Equals " + str4 + ".");
			
		if(str3.equals(str5))
			System.out.println(str3 + " Equals " + str5 + ".");
		else
			System.out.println(str3 + " Not Equals " + str5 + ".");
			
		if(str3.equalsIgnoreCase(str6))
			System.out.println(str3 + " Equals " + str6 + " while ignoring case.");
		else
			System.out.println(str3 + " Not Equals " + str6 + " while ignoring case.");
			
		if(str3.equalsIgnoreCase(str5))
			System.out.println(str3 + " Equals " + str5 + " while ignoring case.");
		else
			System.out.println(str3 + " Not Equals " + str5 + " while ignoring case.");
			
		System.out.println("\nMatching " + str3 + " and " + str4 + ": " + str3.compareTo(str4));
		System.out.println("Matching " + str3 + " and " + str5 + ": " + str3.compareTo(str5));
		System.out.println("Matching " + str3 + " and " + str6 + ": " + str3.compareTo(str6));
		System.out.println("Matching " + str3 + " and " + str5 + " while ignoring case: " + str3.compareToIgnoreCase(str5));
		System.out.println("Matching " + str3 + " and " + str6 + " while ignoring case: " + str3.compareToIgnoreCase(str6));
		
		System.out.println("\n" + str6 + " in upper case " + str6.toUpperCase() + ".");
		System.out.println(str6 + " in lower case " + str6.toLowerCase() + ".");
		
		String str7 = "  Trebuchet  ";
		System.out.println("\nTrimming \"" + str7 + "\" gives: \"" + str7.trim() + "\".");
		
		String str8 = "Cook";
		char ch1 = 'C';
		char ch2 = 'B';
		System.out.println("\nReplacing '" + ch1 + "' in string '" +  str8 + "' with '" + ch2 + "' gives: " + str8.replace(ch1, ch2) + ".");
	}	
}
