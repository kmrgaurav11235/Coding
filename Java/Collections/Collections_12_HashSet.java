import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Collections_12_HashSet
{
	public static void main(String args[])
	{
		HashSet<String> s = new HashSet<>();
		s.add("Kings Landing");
		s.add("Winterfell");
		s.add("Casterly Rock");
		s.add("Winterfell");
		s.add("Riverrun");
		s.add("The Eyrie");
		s.add("Sunspear");
		s.add("Pike");
		s.add("HighGarden");
		
		System.out.println("HashSet: " + s);
		
		System.out.println("\nIs 'Sunspear' present in HashSet? " + s.contains("Sunspear"));
		System.out.println("\nIs 'White Harbor' present in HashSet? " + s.contains("White Harbor"));
		
		System.out.println("\nRemoving 'Pike' from the HashSet:");
		s.remove("Pike");
		System.out.println("HashSet: " + s);
		
		System.out.println("\nUsing Iterator to print all elements of HashSet:");
		Iterator i = s.iterator();
		while(i.hasNext())
		{
			System.out.println((String)(i.next()));
		}
	}
}
