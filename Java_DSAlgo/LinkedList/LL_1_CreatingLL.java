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
class LL_1_CreatingLL
{
	public static void main(String args[])
	{
		LinkedList l1 = new LinkedList();
		LinkedList.Node n1 = l1.new Node(10);
		LinkedList.Node n2 = l1.new Node(20);
		LinkedList.Node n3 = l1.new Node(30);
		
		l1.start = n1;
		n1.next = n2;
		n2.next = n3;
		
		System.out.println(l1);
	}
}
