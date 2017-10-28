class NamingConventionExample
{
	static final double INT_MAX = 1.0/0.0;
	static final double INT_MIN = -1.0/0.0;
	static final double NaN = 0.0/0.0;
	
	double numA = 10.0;
	
	NamingConventionExample()
	{
	}
	
	public void display()
	{
		if(INT_MAX > numA)
			System.out.println(numA + " is less than " + INT_MAX + ".");
		else
			System.out.println(numA + " is greater than " + INT_MAX + ".");
			
		if(INT_MIN > numA)
			System.out.println(numA + " is less than " + INT_MIN + ".");
		else
			System.out.println(numA + " is greater than " + INT_MIN + ".");
		
		System.out.println(NaN + " is not a number.");
	}
}

class Basic_2_NamingConvention
{
	public static void main(String args[])
	{
		NamingConventionExample nNew = new NamingConventionExample();
		nNew.display();
	}
}
