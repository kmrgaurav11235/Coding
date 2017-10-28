class Operator_2_ComparisionOfAutoBoxedIntegers
{
	public static void main(String args[])
	{
		//Since X1 and X2 refer to different objects, we get the output as X1 != X2
		Integer x1 = 1000;
		Integer x2 = 1000;
		if(x1 == x2)
			System.out.println("X1 = X2");
		else
			System.out.println("X1 != X2");
		
		//In Java, values from -128 to 127 are cached, so the same objects are returned. Y1 = Y2
		Integer y1 = 10;
		Integer y2 = 10;
		if(y1 == y2)
			System.out.println("Y1 = Y2");
		else
			System.out.println("Y1 != Y2");
		
		//If we explicitly create Integer objects using new operator, we get the output as Z1 != Z2
		Integer z1 = new Integer(10);
		Integer z2 = new Integer(10);
		if(z1 == z2)
			System.out.println("Z1 = Z2");
		else
			System.out.println("Z1 != Z2");
		
		
	}
}
