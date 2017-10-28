import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
class Map_2_HashMap2
{
	public static void main(String args[])
	{
		HashMap<String, Integer> m = new HashMap<>();
		m.put("India", new Integer(10));
		m.put("Russia", new Integer(12));
		m.put("USA", new Integer(14));
		m.put("Democratic Republic of Congo", new Integer(15));
		m.put("Brazil", new Integer(17));
		m.put("South Africa", new Integer(19));
		m.put("Australia", new Integer(20));
		m.put("Zaire", new Integer(15));
		m.put("Bharat", new Integer(10));
		m.put("Aryavartha", new Integer(10));
		
		System.out.println("HashSet: " + m);
		
		System.out.println("\nAll Keys of HashMap:");
		Set<String> s = m.keySet();
		for(String str: s)
		{
			System.out.print(str + ", ");
		}
		
		System.out.println("\n\nAll Values of HashMap:");
		Collection<Integer> c = m.values();
		for(Integer i: c)
		{
			System.out.print(i + ", ");
		}
		
		System.out.println("\n\nAll Key-Values of HashMap:");
		
		Set<Map.Entry<String, Integer> > kvp = m.entrySet();
		for(Map.Entry<String, Integer> me: kvp)
		{
			System.out.println(me.getKey() + ": " + me.getValue());
		}
	}
}
