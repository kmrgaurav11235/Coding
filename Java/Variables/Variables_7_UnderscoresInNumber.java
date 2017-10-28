class Variables_7_UnderscoresInNumber
{
	public static void main(String args[])
	{
		//A new feature was introduced by JDK 7 which allows to write numeric literals using the underscore character. 
		//Numeric literals are broken to enhance the readability.
		int x = 1_000;
		long y = 1_00_00_000;
		double z = 23_567_590.555_111_45;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}

