class Operator_1_RightShiftOperator
{
	public static void main(String args[])
	{
		int x = 1024;
		int y = -1024;
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		
		/*In Java, the operator ‘>>’ is signed right shift operator. All integers are signed in Java, and it is fine to use >> for 
		negative numbers. The operator ‘>>’ uses the sign bit (left most bit) to fill the trailing positions after shift. If the 
		number is negative, then 1 is used as a filler and if the number is positive, then 0 is used as a filler.
		*/
		x = x >> 1;
		System.out.println("\nSigned Right Shift");
		System.out.println("X = X >> 1. X = " + x);
		y = y >> 1;
		System.out.println("Y = Y >> 1. y = " + y);
		
		x = x >> 2;
		System.out.println("X = X >> 2. X = " + x);
		y = y >> 2;
		System.out.println("Y = Y >> 2. Y = " + y);
		
		//In Java, the operator ‘>>>’ is unsigned right shift operator. It always fills 0 irrespective of the sign of the number.
		System.out.println("\nUn-signed Right Shift");
		x = x >>> 1;
		System.out.println("X = X >>> 1. X = " + x);
		y = y >>> 1;
		System.out.println("Y = Y >>> 1. y = " + y);
		
		x = x >>> 2;
		System.out.println("X = X >>> 2. X = " + x);
		y = y >>> 2;
		System.out.println("Y = Y >>> 2. Y = " + y);
	}
}
