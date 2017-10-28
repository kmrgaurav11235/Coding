class Operator_3_NumericPromotionInConditionalExp
{
	public static void main(String args[])
	{
		Object o1, o2;
		
		o1 = ((true)?(new Integer(10)):(new Double(14.0)));
		
		if(true)
			o2 = new Integer(10);
		else
			new Double(14.0);
		
		System.out.println("o1 = " + o1);
		System.out.println("o2 = " + o2);
		
		/*
		The conditional operator will implement numeric type promotion if there are two different types as 2nd and 3rd operand.  
		The rules of conversion are defined at Binary Numeric Promotion. Therefore, according to the rules given, If either operand 
		is of type double, the other is converted to double and hence 10 becomes 10.0.
		 */
	}
}
