import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Collections_2_Iterator
{
	public static void main(String args[])
	{
		ArrayList al = new ArrayList();
		Random r = new Random();
		
		for(int i = 0; i < 20; i++)
		{
			al.add(r.nextInt(101));
		}
		
		System.out.println("Arraylist: " + al);
		
		Iterator i = al.iterator();
		
		System.out.println("\nPrinting Arraylist using Iterator:");
		while(i.hasNext())
		{
			int data = (Integer)i.next();
			System.out.print(data + ", ");
			if(data % 2 == 0)
			{
				i.remove();
				//Removing Even elements
			}
		}
		
		System.out.println("\n\nRemoved even elemets.");
		System.out.println("\nArraylist after change: " + al);
	}
}
