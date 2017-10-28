import java.util.LinkedHashSet;
import java.util.Iterator;
class Collections_13_LinkedHashSet
{
	public static void main(String args[])
	{
		LinkedHashSet<String> s = new LinkedHashSet<>();
		s.add("Kings Landing");
		s.add("Winterfell");
		s.add("Casterly Rock");
		s.add("Winterfell");
		s.add("Riverrun");
		s.add("The Eyrie");
		s.add("Sunspear");
		s.add("Pike");
		s.add("HighGarden");
		
		System.out.println("LinkedHashSet always accesses data in the same order in which it was inserted.");
		System.out.println("LinkedHashSet: " + s);
		System.out.println("LinkedHashSet Size: " + s.size());
		
		System.out.println("\nIs 'Sunspear' present in LinkedHashSet? " + s.contains("Sunspear"));
		System.out.println("\nIs 'White Harbor' present in LinkedHashSet? " + s.contains("White Harbor"));
		
		System.out.println("\nRemoving 'Pike' from the LinkedHashSet:");
		s.remove("Pike");
		System.out.println("LinkedHashSet: " + s);
		
		System.out.println("\nUsing Iterator to print all elements of LinkedHashSet:");
		Iterator i = s.iterator();
		while(i.hasNext())
		{
			System.out.println((String)(i.next()));
		}
	}
}
