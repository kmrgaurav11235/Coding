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
		String str = "";
		Node p = start;
		
		while(p != null)
		{
			str = str + p.data + " ";
			p = p.next;
		}
		return str;
	}
	
	void reverseLL()
	{
		Node pPrev = null, p = start, pNext;
		while(p != null)
		{
			pNext = p.next;
			p.next = pPrev;
			pPrev = p;
			p = pNext;
		}
		start = pPrev;
	}
}

class LL_6_ReverseLL
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
		
		System.out.println("\nReversing the LinkedList.");
		l1.reverseLL();
		
		System.out.println("\nLinked List:");	
		System.out.println(l1);	
	}
}
