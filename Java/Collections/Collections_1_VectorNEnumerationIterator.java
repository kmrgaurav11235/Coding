import java.util.Enumeration;
import java.util.Vector;
import java.util.Random;

class Collections_1_VectorNEnumerationIterator
{
	public static void main(String args[])
	{
		Vector v = new Vector();
		Random r = new Random();
		for(int i = 0 ; i < 10; i++)
		{
			v.addElement(r.nextInt(101));
		}
		
		System.out.println("Vector: " + v);
		
		Enumeration e = v.elements();
		System.out.println("\nPrinting vector using Enumeration:");
		while(e.hasMoreElements())
		{
			System.out.print((Integer)(e.nextElement()) + ", ");
		}
	}
}
/*
 * Limitations of Enumeration :
 * 		Enumeration is for legacy classes(Vector, Hashtable) only. Hence it is not a universal iterator.
 * 		Remove operations can’t be performed using Enumeration.
 * 		Only forward direction iterating is possible.
 */
