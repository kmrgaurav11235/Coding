import java.util.ArrayList;

class Arrays_6_ArrayVsArrayList
{
	public static void main(String args[])
	{
		System.out.println("Difference 1: Arrays are static. ArrayLists are dynamic.");
		/*
		 * An array is basic functionality provided by Java. ArrayList is part of collection framework in Java. Therefore array members 
		 * are accessed using [], while ArrayList has a set of methods to access elements and modify them. 
		 */
		String names[] = new String[5];
		names[0] = "Eragorn";
		names[1] = "Roran";
		names[2] = "Mortza";
		names[3] = "Saphira";
		names[4] = "Thorn";
		//names[5] = "Shruikan"; //This will give exception
		
		ArrayList<String> nameList = new ArrayList<>(5);//the declaration of size '(5)' is optional. Just '()' will work too.
		nameList.add("Eragorn");
		nameList.add("Roran");
		nameList.add("Mortza");
		nameList.add("Saphira");
		nameList.add("Thorn");
		nameList.add("Shruikan");//No exception
		
		System.out.println("\nArray (Initally declared size = 5):");
		for(String str: names)
		{
			System.out.println(str);
		}
		
		System.out.println("\nArray List (Initally declared size = 5):");
		for(String str: nameList)
		{
			System.out.println(str);
		}		
		
		System.out.println("\nDifference 2: Arrays can be created from primary data types. ArrayLists can be created only from objects.");
		
		int marks[] = {47, 98, 100, 56, 31, 67, 32};
		ArrayList<Integer> marksList = new ArrayList<>();
		//ArrayList<int> marksList1 = new ArrayList<>(); //will not work
		//ArrayList<char> marksList2 = new ArrayList<>(); //will not work
		marksList.add(47);
		marksList.add(98);
		marksList.add(100);
		marksList.add(56);
		marksList.add(31);
		marksList.add(67);
		marksList.add(32);
		
		System.out.println("\nArray of Marks:");
		for(int i: marks)
		{
			System.out.println(i);
		}
		
		System.out.println("\nArray List of Marks:");
		for(Integer i: marksList)
		{
			System.out.println(i);
		}	
		
		/*
		 * Difference 3: Arrays store primitive data in contiguous memory locations. For Object data, they store references in contiguous
		 * memory locations. The actual objects are not stored in contiguous locations. ArrayList can be only made up of Objects. So, 
		 * they also store references in contiguous memory locations. The actual objects are not stored in contigious locations.
		 */
		
	}
}
