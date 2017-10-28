class Variables_2_VariableScope
{
	public static void main(String args[])
	{
		int x = 10;
		for(int x = 0; x < 10; x++)
		{
			//This works in C++. Not in java
			System.out.println("X = " + x);
		}
		
		{
			//This works in C++. Not in java
			int x = 20;
			System.out.println("X = " + x);			
		}
	}
}
