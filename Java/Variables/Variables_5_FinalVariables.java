class FinalVarClass
{
	private final int x = 10;
	void display()
	{
		System.out.println("X = " + x);
		
		//Error
		//x++;
		/*
		When final keyword is used with a variable of primitive data types (int, float, .. etc), value of the variable cannot be changed. 
		 */
	}
}
class FinalVarClass2
{
	private int x = 100;
	void display()
	{
		System.out.println("Old X = " + x);
		
		//No error
		x++;
		
		System.out.println("New X = " + x);
		
		/*
		When final is used with non-primitive variables, the members of the referred object can be changed. final for non-primitive 
		variables just mean that they cannot be changed to refer to any other object 
		 */
	}	
}
class Variables_5_FinalVariables
{
	public static void main(String args[])
	{
		FinalVarClass f1 = new FinalVarClass();
		f1.display();
		final FinalVarClass2 f2 = new FinalVarClass2();
		f2.display();
		
		//error
		//f2 = new FinalVarClass2();
	}
}
