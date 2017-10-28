import java.util.HashMap;
class Map_1_HashMap1
{
	public static void main(String args[])
	{
		HashMap<String, Integer> m = new HashMap<>();
		m.put("India", new Integer(10));
		m.put("Russia", new Integer(12));
		m.put("USA", new Integer(14));
		m.put("Brazil", new Integer(17));
		m.put("South Africa", new Integer(19));
		m.put("Australia", new Integer(20));
		
		System.out.println("HashSet: " + m);
		
		System.out.println("\nIs HashSet empty: " + m.isEmpty());
		System.out.println("\nHashSet size: " + m.size());
		System.out.println("\nDoes HashSet contains key 'India'? " + m.containsKey("India"));
		System.out.println("Does HashSet contains key 'Pakistan'? " + m.containsKey("Pakistan"));
		
		System.out.println("\nGet value for key 'Russia'? " + m.get("Russia"));
		System.out.println("Get value for key 'South Africa'? " + m.get("South Africa"));
		System.out.println("Get value for key 'Nigeria'? " + m.get("Nigeria"));
	}
}
