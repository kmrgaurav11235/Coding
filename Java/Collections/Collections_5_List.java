import java.util.List;
import java.util.ArrayList;

class Collections_5_List
{
	public static void main(String args[])
	{
		List<String> lis1 = new ArrayList<>();
		
		lis1.add("Twinkle");
		lis1.add("Twinkle");
		lis1.add("little");
		lis1.add("star,");
		lis1.add("you");
		lis1.add("look");
		lis1.add("small");
		lis1.add("coz");
		lis1.add("you're");
		lis1.add("far!");
		
		System.out.println("List: " + lis1);
		
		System.out.println("\nGetting element at index 3:" + lis1.get(3));
		
		System.out.println("\nSetting element at index 8 as 'you'.");
		lis1.set(8, "you");
		System.out.println("Modified List: " + lis1);
		System.out.println("\nAdding element 'are' at index 9.");
		lis1.add(9, "are");
		System.out.println("Modified List: " + lis1);
		
		System.out.println("\nRemoving element at index 1.");
		lis1.remove(1);
		System.out.println("Modified List: " + lis1);
		System.out.println("Adding it back at index 1.");
		lis1.add(1, "twinkle");
		System.out.println("Modified List: " + lis1);
		
		System.out.println("\nFirst Index of word 'you': " + lis1.indexOf("you"));
		System.out.println("Last Index of word 'you': " + lis1.lastIndexOf("you"));
		
		
		System.out.println("\nCreating a New List: ");
		List<String> lis2 = new ArrayList<>();
		lis2.add("Lightyears");
		lis2.add("out");
		lis2.add("from");
		lis2.add("here");
		lis2.add("to");
		lis2.add("there,");
		lis2.add("your");
		lis2.add("light's");
		lis2.add("distorted");
		lis2.add("by");
		lis2.add("the");
		lis2.add("air");
		System.out.println("New List: " + lis2);
		System.out.println("\nAdding New List at the end of old one.");
		lis1.addAll(lis2);
		System.out.println("Modified List: " + lis1);
		
		System.out.println("\nMaking new list by taking the old lists elements [5 to 9[.");
		List<String> lis3 = new ArrayList<>();
		lis3 = lis1.subList(5, 9);
		System.out.println("New List: " + lis3);
		
		
		System.out.println("\nClearig the List.");
		lis1.clear();
		System.out.println("Cleared List: " + lis1);
		
	}
}
