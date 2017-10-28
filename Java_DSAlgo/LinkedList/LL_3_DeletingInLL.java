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
	
	boolean deleteByValue(int info)
	{
		Node p = null;
		Node q = start;
		
		if(q != null && q.data == info)
		{
			start = start.next;
			return true;
		}
		
		while(q != null && q.data != info)
		{
			p = q;
			q = q.next;
		}
		
		if(q == null)
			return false;
		
		p.next = q.next;
		return true;
	}
	
	boolean deleteByPosition(int pos)
	{
		Node q = start;
		Node p = null;
		
		if(q == null)
			return false;
		
		if(pos < 1)
			return false;
		else if(pos == 1)
		{
			start = start.next;
			return true;
		}
		
		int i;
		for(i = 1; i < pos && q != null; i++)
		{
			p = q;
			q = q.next;
		}
		
		if(q == null)
			return false;
		
		p.next = q.next;
		return true;
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
class LL_3_DeletingInLL
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
		
		System.out.println("Linked List:");	
		System.out.println(l1 + "\n");	
		
		int a = -10, b = 10, c = 15;
		if(l1.deleteByValue(a))
			System.out.println(a + " deleted from LL.");
		else
			System.out.println(a + " not found in LL.");
		
		if(l1.deleteByValue(b))
			System.out.println(b + " deleted from LL.");
		else
			System.out.println(b + " not found in LL.");
		
		if(l1.deleteByValue(c))
			System.out.println(c + " deleted from LL.");
		else
			System.out.println(c + " not found in LL.");
		
		System.out.println("\nLinked List:");	
		System.out.println(l1);
			
		int pos1 = 1, pos2 = 0, pos3 = 3, pos4 = 5;
		if(l1.deleteByPosition(pos1))
			System.out.println("\nElement at position " + pos1 + " deleted from LL.");
		else
			System.out.println("Position " + pos1 + " not found in LL.");
		
		if(l1.deleteByPosition(pos2))
			System.out.println("Element at position " + pos2 + " deleted from LL.");
		else
			System.out.println("Position " + pos2 + " not found in LL.");
		
		if(l1.deleteByPosition(pos3))
			System.out.println("Element at position " + pos3 + " deleted from LL.");
		else
			System.out.println("Position " + pos3 + " not found in LL.");
		
		if(l1.deleteByPosition(pos4))
			System.out.println("Element at position " + pos4 + " deleted from LL.");
		else
			System.out.println("Position " + pos4 + " not found in LL.");
		
		System.out.println("\nLinked List:");	
		System.out.println(l1);
	}
}
