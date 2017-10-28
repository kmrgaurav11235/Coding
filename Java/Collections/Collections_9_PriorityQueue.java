import java.util.PriorityQueue;
import java.util.Iterator;
class Collections_9_PriorityQueue
{
	public static void main(String args[])
	{
		PriorityQueue<String> q = new PriorityQueue<>();
		q.add("the");
		q.add("shadows");
		q.add("come");
		q.add("to");
		q.add("dance");
		q.add("my");
		q.add("lord");
		q.add("the");
		q.add("shadows");
		q.add("come");
		q.add("to");
		q.add("stay");
		q.add("my");
		q.add("lord");
		
		System.out.println("Priority Queue: " + q +  "\nDisplay is not according to priority.");
		
		System.out.println("\nPrinting Priority Queue using iterator: ");
		Iterator i = q.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next() + " ");
		}
		System.out.println("Iterator Display is also not according to priority.");
		
		System.out.println("\nDequeuing from Priority Queue: " + q.poll());
		System.out.println("Dequeuing from Priority Queue: " + q.poll());
		System.out.println("Dequeuing from Priority Queue: " + q.poll());
		System.out.println("Dequeuing from Priority Queue: " + q.poll());
		System.out.println("Dequeuing from Priority Queue: " + q.poll());
		System.out.println("Priority Queue: " + q);
		
		
		System.out.println("\nPeeking into Priority Queue: " + q.peek());
		
		System.out.println("\nIs 'shadows' present in Priority Queue: " + q.contains("shadows"));
		System.out.println("Is 'ShaDows' present in Priority Queue: " + q.contains("ShaDows"));
		System.out.println("Is 'Rh'ollor' present in Priority Queue: " + q.contains("Rh'ollor"));
		
		System.out.println("\nFunctionality of remove() is same as poll()");
		System.out.println("Dequeuing from Priority Queue: " + q.remove());
		System.out.println("Dequeuing from Priority Queue: " + q.remove());
		System.out.println("Dequeuing from Priority Queue: " + q.remove());
		System.out.println("Dequeuing from Priority Queue: " + q.remove());
		System.out.println("Dequeuing from Priority Queue: " + q.remove());
		System.out.println("Priority Queue: " + q);
		
		System.out.println("\nRemoving 'to' from Priority Queue. Success? " + q.remove("to"));
		System.out.println("Removing 'shadows' from Priority Queue. Success? " + q.remove("shadows"));
		System.out.println("Priority Queue: " + q);
	}
}
