class Variables_8_TypeConversion
{
	public static void main(String args[])
	{
		byte b1 = 65;
		short s1 = 1156;
		int i1 = 63122;
		long l1 = 4_678_234_651l;
		float f1 = 3.14f;
		double d1 = 1.414579877;
		char ch1 = 'X';		
		System.out.println("byte b1 = " + b1);
		System.out.println("short s1 = " + s1);
		System.out.println("int i1 = " + i1);
		System.out.println("long l1 = " + l1);
		System.out.println("float f1 = " + f1);
		System.out.println("double d1 = " + d1);
		System.out.println("char ch1 = " + ch1 + "\n");
		
		
		System.out.println("Automatic Conversions.");
		int i2 = b1;
		double d2 = f1;		
		System.out.println("int i2 = b1. i2 = " + i2);
		System.out.println("double d2 = f1. d2 = " + d2 + "\n");
		
		
		System.out.println("Explicit Conversions.");
		byte b2 = (byte)s1;
		short s2 = (short)i1;
		int i3 = (int)l1;
		int i4 = (int)f1;
		int i5 = (int)ch1;
		long l2 = (long)d1;
		float f2 = (float)d1;
		char ch2 = (char)b1;		
		System.out.println("byte b2 = (byte)s1. b2 = " + b2);
		System.out.println("short s2 = (short)i1. s2 = " + s2);
		System.out.println("int i3 = (int)l1. i3 = " + i3);
		System.out.println("int i4 = (int)f1. i4 = " + i4);
		System.out.println("int i5 = (int)ch1. i5 = " + i5);
		System.out.println("long l2 = (long)d1. l2 = " + l2);
		System.out.println("float f2 = (float)d1. f2 = " + f2);
		System.out.println("char ch2 = (char)b1. ch2 = " + ch2 + "\n");
		
		/*
		While evaluating expressions, the intermediate value may exceed the range of operands and hence the expression value will 
		be promoted. Some conditions for type promotion are:
			-> Java automatically promotes each byte, short, or char operand to int when evaluating an expression.
			-> If one operand is a long, float or double the whole expression is promoted to long, float or double respectively.

		 */
		System.out.println("Type promotion in Expressions.");
		double d3 = f1 * b1 + l1 * s1 + ch1/i1;
		System.out.println("double d3 = f1 * b1 + l1 * s1 + ch1/i1. d3 = " + d3 + "\n");
		
		//While evaluating expressions, the result is automatically updated to larger data type  of the operand. But if we store 
		//that result in any smaller data type it generates compile time error, due to which we need to type cast the result.
		System.out.println("Explicit type casting in Expressions");
		byte b3 = (byte)(b1 * 2);
		System.out.println("byte b3 = (byte)(b1 * 2). b3 = " + b3);
	}
}
