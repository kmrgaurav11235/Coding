class Variables_4_MoreNumbers
{
	public static void main(String args[])
	{
		int num1 = 012;
		System.out.println(num1);
		/*The reason for above output is, when a 0 is prefixed the value is considered octal, since 12 in octal is 10 in decimal, 
		the result is 10.
		*/
		
		System.out.println(1 + 1 + "Fast" + 1 + 1 + "Furious");
		/*
		Java takes the numbers before the strings are introduced as int and once the string literals are introduced, 
		all the following numbers are considered as strings.
		 */
	}
}
