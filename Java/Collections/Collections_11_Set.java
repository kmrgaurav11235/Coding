import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

class Collections_11_Set
{
	public static void main(String args[])
	{
		Set<String> s = new HashSet<>();
		s.add("the");
		s.add("lion");
		s.add("doesn't");
		s.add("cares");
		s.add("about");
		s.add("the");
		s.add("opinions");
		s.add("of");
		s.add("the");
		s.add("sheep");
		
		System.out.println("All sets have no duplicates.");
		System.out.println("\nHashSet: " + s);
		System.out.println("HashSet can be printed in any order.");
		
		Set<String> s1 = new TreeSet<>();
		s1.add("the");
		s1.add("lion");
		s1.add("doesn't");
		s1.add("cares");
		s1.add("about");
		s1.add("the");
		s1.add("opinions");
		s1.add("of");
		s1.add("the");
		s1.add("sheep");
		System.out.println("\nTreeSet: " + s1);
		System.out.println("TreeSet is always in alphabetical order.");
		
		Set<String> s2 = new HashSet<>();
		s2.add("and");
		s2.add("who");
		s2.add("are");
		s2.add("you");
		s2.add("the");
		s2.add("proud");
		s2.add("lord");
		s2.add("said");
		s2.add("that");
		s2.add("i");
		s2.add("must");
		s2.add("bow");
		s2.add("so");
		s2.add("low");
		
		Set<String> s3 = new HashSet<>();
		s3.add("only");
		s3.add("a");
		s3.add("cat");
		s3.add("of");
		s3.add("different");
		s3.add("coat");
		s3.add("that");
		s3.add("is");
		s3.add("all");
		s3.add("the");
		s3.add("truth");
		s3.add("i");
		s3.add("know");
		
		System.out.println("\nHashSet 1: " + s2);
		System.out.println("HashSet 2: " + s3);
		
		Set<String> union = new HashSet<>(s2);
		Set<String> intersection = new HashSet<>(s2);
		Set<String> difference = new HashSet<>(s2);
		
		union.addAll(s3);
		System.out.println("\nUnion Set: " + union);
		
		intersection.retainAll(s3);
		System.out.println("\nIntersection Set: " + intersection);
		
		difference.removeAll(s3);
		System.out.println("\nDifference Set: " + difference);
	}
}
