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
	
	void insertAfter(int info, Node p)
	{
		if(p == null)
		{
			insertAtStart(info);
			return;
		}
		Node temp = new Node(info);
		temp.next = p.next;
		p.next = temp;
	}
	
	void append(int info)
	{
		Node temp = new Node(info);
		
		if(start == null)
		{
			start = temp;
			return;
		}
		
		Node p = start;
		while(p.next != null)
			p = p.next;
		
		p.next = temp;
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
class LL_2_InsertingInLL
{
	public static void main(String args[])
	{
		LinkedList l1 = new LinkedList();
		
		l1.insertAtStart(40);
		l1.insertAtStart(30);
		l1.insertAtStart(20);
		
		l1.append(70);
		l1.append(80);
		l1.append(90);
		
		l1.insertAfter(60, l1.start.next.next);
		l1.insertAfter(50, l1.start.next.next);
		
		System.out.println(l1);		
	}
}
