import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;

//Stack class extends Vector class with five methods that allow a vector to be treated as a stack.
class Collections_8_Stack
{
	public static void main(String args[])
	{		
		Stack<Integer> s = new Stack<>();
		System.out.println("Created new Stack. Stack: " + s);
		System.out.println("Is Stack empty? " + s.empty());
		
		System.out.println("\nPushing a few elements to Stack.");
		s.push(new Integer(11));
		s.push(new Integer(42));
		s.push(new Integer(97));
		s.push(new Integer(9));
		s.push(new Integer(5));
		s.push(new Integer(11));
		System.out.println("Stack: " + s);
		
		System.out.println("\nPopping from stack: " + s.pop());
		System.out.println("Popping from stack: " + s.pop());
		System.out.println("Stack: " + s);		
		
		System.out.println("\nSearching 11 in stack. Index: " + s.search(11));
		System.out.println("\nSearching 43 in stack. Index: " + s.search(43));
		
		System.out.println("\nPeeking in stack: " + s.peek());
		System.out.println("Stack: " + s);
		
	}
}
