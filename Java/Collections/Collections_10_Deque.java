import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;
class Collections_10_Deque
{
	public static void main(String args[])
	{
		Deque<String> dq = new LinkedList<>();	
		dq.add("Blood");
		dq.add("on");
		dq.add("maidens");
		dq.add("thigh");
		dq.add("but");
		dq.add("chains");
		dq.add("for");
		dq.add("the");
		dq.add("guest");
		dq.add("and");
		dq.add("chains");
		
		System.out.println("Deque:\n" + dq);
		
		dq.addFirst("blood");
		dq.addFirst("Kings");
		System.out.println("\nDeque after adding elements at beginning:\n" + dq);
		
		dq.addLast("for");
		dq.addLast("the");
		System.out.println("\nDeque after adding elements at last:\n" + dq);
		
		dq.offer("bridgegroom");
		dq.offer("aye aye aye");
		System.out.println("\nDeque after offering elements:\n" + dq);
		
		dq.offerFirst("blood");
		dq.offerFirst("Fools");
		System.out.println("\nDeque after offering elements at beginning:\n" + dq);
		
		dq.offerLast("patchface");
		dq.offerLast("prophecy");
		System.out.println("\nDeque after offering elements at last:\n" + dq);
		
		dq.push("Patchface");
		dq.push("sang");
		dq.push("loudly");
		System.out.println("\nDeque after pushing elements:\n" + dq);
		
		System.out.println("\nPopping element: " + dq.pop());
		System.out.println("Deque after pushing elements:\n" + dq);
		
		System.out.println("\nRemoving element from first: " + dq.removeFirst());
		System.out.println("Removing element from first: " + dq.removeFirst());
		System.out.println("Deque after removing elements at first:\n" + dq);
		
		System.out.println("\nRemoving element from last: " + dq.removeLast());
		System.out.println("Removing element from last: " + dq.removeLast());
		System.out.println("Deque after removing elements at first:\n" + dq);
		
		System.out.println("Printing Deque using Iterator:\n");
		for(Iterator i = dq.iterator(); i.hasNext();)
		{
			System.out.print(i.next() + " ");
		}
		
		System.out.println("\n\nPrinting Deque using descending Iterator:\n");
		for(Iterator i = dq.descendingIterator(); i.hasNext();)
		{
			System.out.print(i.next() + " ");
		}
	}
}
