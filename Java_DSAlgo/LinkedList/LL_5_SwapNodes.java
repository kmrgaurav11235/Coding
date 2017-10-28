/*
 * Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data 
 * of nodes may be expensive in many situations when data contains many fields. 
 * This may look a simple problem, but is interesting question as it has following cases to be handled.
 * 		1) x and y may or may not be adjacent.
 * 		2) Either x or y may be a head node.
 * 		3) Either x or y may be last node.
 * 		4) x and/or y may not be present in linked list.
 */
class LinkedList
{
	class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	Node start;
	
	void insertAtStart(int info)
	{
		Node temp = new Node(info);
		temp.next = start;
		start = temp;
	}
	
	@Override
	public String toString()
	{
		Node p = start;
		String str = "";
		while(p != null)
		{
			str = str + p.data + " ";
			p = p.next;
		}
		return str;
	}
	
	boolean swapNodes(int info1, int info2)
	{
		if(info1 == info2)
			return true;
		Node p = start, q = start;
		Node pPrev = null, qPrev = null;
		
		while(p != null && p.data != info1)
		{
			pPrev = p;
			p = p.next;
		}
		while(q != null && q.data != info2)
		{
			qPrev = q;
			q = q.next;
		}
		if(p == null || q == null)//one of the elements is absent
			return false;
		
		if(pPrev != null)
			pPrev.next = q;//changing pointer
		else
			start = q;//make q the starting point as p was starting point initially
		
		if(qPrev != null)
			qPrev.next = p;
		else
			start = p;
		
		Node r = p.next;
		p.next = q.next;
		q.next = r;
		
		return true;
	}
}
class LL_5_SwapNodes
{
	public static void main(String args[])
	{
		LinkedList l1 = new LinkedList();
		
		l1.insertAtStart(60);
		l1.insertAtStart(50);
		l1.insertAtStart(40);
		l1.insertAtStart(30);
		l1.insertAtStart(20);
		l1.insertAtStart(10);
		l1.insertAtStart(0);
		l1.insertAtStart(-10);
		
		System.out.println("\nLinked List:");	
		System.out.println(l1);	
		
		int info1 = 40, info2 = 10, info3 = 20, info4 = 30, info5 = -10, info6 = 50, info7 = 60, info8 = 15;
		System.out.println("\nTrying to swap " + info1 + " and " + info2 + "." );
		if(l1.swapNodes(info1, info2))
			System.out.println("Nodes swapped successfully.");
		else
			System.out.println("Couldn't swap Nodes.");
		System.out.println("\nLinked List:");	
		System.out.println(l1);	
		
		System.out.println("\nTrying to swap " + info3 + " and " + info4 + "." );
		if(l1.swapNodes(info3, info4))
			System.out.println("Nodes swapped successfully.");
		else
			System.out.println("Couldn't swap Nodes.");
		System.out.println("\nLinked List:");	
		System.out.println(l1);	
		
		System.out.println("\nTrying to swap " + info5 + " and " + info6 + "." );
		if(l1.swapNodes(info5, info6))
			System.out.println("Nodes swapped successfully.");
		else
			System.out.println("Couldn't swap Nodes.");
		System.out.println("\nLinked List:");	
		System.out.println(l1);	
		
		System.out.println("\nTrying to swap " + info7 + " and " + info8 + "." );
		if(l1.swapNodes(info7, info8))
			System.out.println("Nodes swapped successfully.");
		else
			System.out.println("Couldn't swap Nodes.");
		System.out.println("\nLinked List:");	
		System.out.println(l1);	
		
		
	}
}
