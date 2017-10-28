class VariableTypes
{
	//Instance variable
	public int instVar;
	
	//Static Variable
	public static int stVar;
	/*
	-> Static Variables: Static variables are declared using the static keyword within a class outside any method constructor or block.
    -> Unlike instance variables, we can only have only copy of a static variable per class irrespective of how many objects we create.
    -> Static variables are created at start of program execution and destroyed automatically when execution ends.
    -> To access static variables, we need not to create any object of that class, we can simply access the variable as:
		class_name.variable_name;
    -> Unlike C++, Java doesn’t support static local variables. For example, the following Java program fails in compilation.
	 */
	
	public void display()
	{
		//Local Variable
		int localVar = 10;
		System.out.println("Local Var = " + localVar);
		
		//Static var inside methods are not allowed
		//static int x = 1;
	}
}
class Variables_1_VariableTypes
{
	public static void main(String args[])
	{
		VariableTypes.stVar = 1;
		System.out.println("No object created yet. Static Var = " + VariableTypes.stVar);
		
		VariableTypes v = new VariableTypes();
		System.out.println("New Object created yet. Instance Var = " + v.instVar);
		
		v.display();		
	}
}
