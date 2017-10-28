import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
class Map_3_HashMap3
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
		
		System.out.println("\nGet Value of 'Bharat' or Default in HashSet: " + m.getOrDefault("Bharat", 0));
		System.out.println("Get Value of 'USA' or Default in HashSet: " + m.getOrDefault("USA", 0));
		System.out.println("Get Value of 'South Korea' or Default in HashSet: " + m.getOrDefault("South Korea", 0));
		
		System.out.println("\nPut Value of 'Bharat' if Absent in HashSet: " + m.putIfAbsent("Bharat", 0));
		System.out.println("Put Value of 'Greece' if Absent in HashSet: " + m.putIfAbsent("Greece", 22));
		System.out.println("Put Value of 'France' if Absent in HashSet: " + m.putIfAbsent("France", 24));
		System.out.println("HashSet: " + m);
		
		System.out.println("\nReplace Value of 'Brazil' in HashSet: " + m.replace("Brazil", 18));
		System.out.println("Replace Value of 'Hungary' in HashSet: " + m.replace("Hungary", 27));
		System.out.println("Replace Value of 'Bharat' if it is 10 in HashSet: " + m.replace("Bharat", 10, 29));
		System.out.println("Replace Value of 'South Africa' if it is 20 in HashSet: " + m.replace("South Africa", 20, 21));
		System.out.println("HashSet: " + m);
		
		System.out.println("\nRemove mappings from HashSet using Iterator:");
		Iterator<Map.Entry<String, Integer> > i = m.entrySet().iterator();
		while(i.hasNext())
		{
			System.out.println("Removed: " + i.next());
			i.remove();
		}
		System.out.println("HashSet: " + m);
	}
}

