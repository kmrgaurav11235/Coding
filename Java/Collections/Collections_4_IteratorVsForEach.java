import java.util.ArrayList;
import java.util.Iterator;

class Collections_4_IteratorVsForEach
{
	public static void main(String args[])
	{
		ArrayList <String> al1 = new ArrayList<>();
		al1.add("Cobbler Cobbler mend my shoe!");
		al1.add("Get it done by half-past two!");
		al1.add("Stitch it up, And stitch it down!");
		al1.add("Then I will give you Half a crown!!");
		
		ArrayList <String> al2 = new ArrayList<>();
		al2.add("And");
		al2.add("a");
		al2.add("Bang");
		al2.add(", and");
		al2.add("a");
		al2.add("Bang, ");
		al2.add("Bang");
		al2.add("Bang!");
		
		try
		{
			System.out.println("Trying using iterator:");
			for(Iterator i = al1.iterator(); i.hasNext();)
			{
				System.out.println(i.next());
				for(Iterator j = al2.iterator(); i.hasNext();)
				{
					System.out.print(j.next() + " ");
				}
				System.out.println();
			}
		}
		catch(Exception e)
		{
			System.out.println("\nException Occured. Details: ");
			e.printStackTrace();
		}
		
		System.out.println("\nTrying using For-Each:");
		for(String i: al1)
		{
			System.out.println(i);
			for(String j: al2)
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
