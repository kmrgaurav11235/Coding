import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ComplexNumber
{
	int real;
	int img;
	ComplexNumber()
	{
		real = 0;
		img = 0;
	}
	ComplexNumber(int x, int y)
	{
		real = x;
		img = y;
	}
	@Override
	public String toString()
	{
		return ("(" + real + ", " + img + ")");
	}
	void display()
	{
		System.out.println("Complex Number: " + this.toString());
	}
}
class Basic_6_JVM
{
	public static void main(String args[])
	{
		//Loader		
		System.out.println("ComplexNumber class loader: " + ComplexNumber.class.getClassLoader());
		System.out.println("String class loader: " + String.class.getClassLoader());
		System.out.println();
		//Members
		ComplexNumber z1 = new ComplexNumber(2, 5);
		Class c1 = z1.getClass();
		Field f1[] = c1.getDeclaredFields();
		Method m1[] = c1.getDeclaredMethods();
		
		System.out.println("Fields of ComplexNumber Class:");
		for(Field jj:f1)
		{
			System.out.println(jj.getName());
		}
		
		System.out.println("Methods of ComplexNumber Class:");
		for(Method ii: m1)
		{
			System.out.println(ii.getName());
		}
	}
}
