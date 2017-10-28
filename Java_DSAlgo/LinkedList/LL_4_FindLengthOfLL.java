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
	
	int lengthIterative()
	{
		Node p = start;
		int len = 0;
		
		while(p != null)
		{
			len++;
			p = p.next;
		}
		return len;
	}
	
	int lengthRecursiveUtil(Node p)
	{
		if(p == null)
			return 0;
		else
			return 1 + lengthRecursiveUtil(p.next);
	}
	
	int lengthRecursive()
	{
		return lengthRecursiveUtil(start);
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
}
class LL_4_FindLengthOfLL
{
	public static void main(String args[])
	{
		LinkedList l1 = new LinkedList();
		
		System.out.println("Linked List:");	
		System.out.println(l1 + "\n");	
		System.out.println("Length of Linked List using Iterative Method: " + l1.lengthIterative());
		System.out.println("Length of Linked List using Recursive Method: " + l1.lengthRecursive());
		
		l1.insertAtStart(60);
		l1.insertAtStart(50);
		l1.insertAtStart(40);
		l1.insertAtStart(30);
		l1.insertAtStart(20);
		l1.insertAtStart(10);
		l1.insertAtStart(0);
		l1.insertAtStart(-10);
		
		System.out.println("\nLinked List:");	
		System.out.println(l1 + "\n");	
		
		System.out.println("Length of Linked List using Iterative Method: " + l1.lengthIterative());
		System.out.println("Length of Linked List using Recursive Method: " + l1.lengthRecursive());
		
		
	}
}
