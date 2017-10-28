import java.util.SortedSet;
import java.util.TreeSet;
class Collections_14_SortedSet
{
	public static void main(String args[])
	{
		SortedSet<String> s = new TreeSet<>();
		s.add("Water");
		s.add("water");
		s.add("water");
		s.add("everywhere");
		s.add("not");
		s.add("a");
		s.add("drop");
		s.add("to");
		s.add("drink");
		
		System.out.println("Sorted Set: " + s);
		
	}
}
