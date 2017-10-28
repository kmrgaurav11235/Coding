class StringClass_7_StringToInteger
{
	public static void main(String args[])
	{
		String str1 = "142";
		String str2 = "-763";
		String str3 = "+150";
		String str4 = "10000001";
		String str5 = "F";
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		System.out.println("str4 = " + str4);
		System.out.println("str5 = " + str5);
		
		System.out.println("\nUsing Integer.parseInt");
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = Integer.parseInt(str3);
		//int num4 = Integer.parseInt(str1, 2);//This will give NumberFormatException as 142 is not binary
		int num4 = Integer.parseInt(str4, 2);
		int num5 = Integer.parseInt(str5, 16);
		/*
		 * How to use parseInt() method in Java?
		 * There are two variants of this method:
		 * 		public static int parseInt(String s) throws NumberFormatException -  This function parses the string argument as a 
		 * 			signed decimal integer.
		 * 		public static int parseInt(String s, int radix) throws NumberFormatException -  This function parses the string 
		 * 			argument as a signed integer in the radix specified by the second argument.
		 */
		
		System.out.println("Num1 = " + num1);
		System.out.println("Num2 = " + num2);
		System.out.println("Num3 = " + num3);
		System.out.println("Num4 = " + num4);
		System.out.println("Num5 = " + num5);
		
		System.out.println("\nUsing Integer.valueOf");
		int num11 = Integer.valueOf(str1);
		int num12 = Integer.valueOf(str2);
		int num13 = Integer.valueOf(str3);
		int num14 = Integer.valueOf(str4, 2);
		int num15 = Integer.valueOf(str5, 16);
		/*
		 * Difference between parseInt() and valueOf():
		 * parseInt() parses the string and returns the primitive integer type. However, valueOf() returns an Integer object.
		 * valueOf() uses parseInt() internally to convert to integer.
		 */
		
		System.out.println("Num1 = " + num11);
		System.out.println("Num2 = " + num12);
		System.out.println("Num3 = " + num13);
		System.out.println("Num4 = " + num14);
		System.out.println("Num5 = " + num15);
		
		String str11 = "142.961";
		String str12 = "-763.8753467";
		String str13 = "+150e11";
		
		System.out.println("\nDecimal Numbers");
		System.out.println("str1 = " + str11);
		System.out.println("str2 = " + str12);
		System.out.println("str3 = " + str13);
		
		System.out.println("\nUsing Double.parseDouble");
		double dub1 = Double.parseDouble(str11);
		double dub2 = Double.parseDouble(str12);
		double dub3 = Double.parseDouble(str13);
		
		System.out.println("Double1 = " + dub1);
		System.out.println("Double2 = " + dub2);
		System.out.println("Double3 = " + dub3);
	}
}
