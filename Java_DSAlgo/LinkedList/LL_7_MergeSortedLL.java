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
	
	LinkedList()
	{
		start = null;
	}
	
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
	
	void sortedMerge(LinkedList l)
	{
		Node p = start, pPrev = null;
		Node q = l.start;
		
		while(p != null && q != null)
		{
			if(p.data <= q.data)
			{
				pPrev = p;
				p = p.next;
			}
			else
			{
				Node temp = new Node(q.data);
				temp.next = p;
				if(pPrev == null)
				{
					//first node
					start = temp;
					pPrev = temp;
				}
				else
				{
					pPrev.next = temp;
				}
				q = q.next;
			}
		}//end of while
		while(q != null)
		{
			Node temp = new Node(q.data);
			if(pPrev == null)
			{
				//first node
				start = temp;
				pPrev = temp;
			}
			else
			{
				pPrev.next = temp;
			}
			pPrev = temp;
			q = q.next;
		}
	}
}
class LL_7_MergeSortedLL
{
	public static void main(String args[])
	{
		LinkedList l1 = new LinkedList();
		//l1.insertAtStart(55);
		l1.insertAtStart(15);
		l1.insertAtStart(10);
		l1.insertAtStart(5);
		
		LinkedList l2 = new LinkedList();
		l2.insertAtStart(40);
		l2.insertAtStart(20);
		l2.insertAtStart(3);
		l2.insertAtStart(2);
		
		System.out.println("\nLinked Lists:");
		System.out.println("L1: " + l1);
		System.out.println("L2: " + l2);
		
		l1.sortedMerge(l2);
		System.out.println("After merge, L1: " + l1);
	}
}
