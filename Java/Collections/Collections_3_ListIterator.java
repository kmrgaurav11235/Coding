import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

class Collections_3_ListIterator
{
	public static void main(String args[])
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		Random r = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			al.add(r.nextInt(101));
		}
		
		System.out.println("Arraylist: " + al);
		
		ListIterator i = al.listIterator();
		
		System.out.println("\nPrinting Arraylist using ListIterator:");
		while(i.hasNext())
		{
			int data = (Integer)i.next();
			System.out.print(data + ", ");
			if(data % 2 == 0)
			{
				i.remove();
				//Removing Even elements
			}
			else
			{
				data++;
				i.set(data);
				i.add(data);
			}
		}
		
		System.out.println("\n\nRemoved even elemets and added 1 to odd elements and duplicated them.");
		System.out.println("\nArraylist after change: " + al);
		System.out.println("\nPrinting Arraylist using ListIterator is reverse direction:");
		while(i.hasPrevious())
		{
			System.out.print(i.previous() + ", ");
		}
	}
}
