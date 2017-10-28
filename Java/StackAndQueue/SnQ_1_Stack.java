class Stack
{
	private final int MAX_SIZE = 100;
	private int arr[] = new int[MAX_SIZE];
	private int topOfStack;
	Stack()
	{
		topOfStack = -1;
	}
	public boolean isEmpty()
	{
		if(topOfStack == -1)
			return true;
		return false;
	}
	public boolean isFull()
	{
		if(topOfStack == MAX_SIZE - 1)
			return true;
		return false;
	}
	public void push(int num)
	{
		if(!isFull())
			arr[++topOfStack] = num;
	}
	public int pop()
	{
		int num = 0;
		if(!isEmpty())
		{
			num = arr[topOfStack];
			topOfStack--;
		}
		return num;
	}
	public int peek()
	{
		return arr[topOfStack];
	}
	@Override
	public String toString()
	{
		if(isEmpty())
			return "Empty Stack.\n";
		String strStack = "Top\n";
		for(int i = topOfStack; i >= 0; i--)
		{
			strStack = strStack + arr[i] + "\n";
		}
		strStack += "Bottom\n";
		return strStack;
	}
}
class SnQ_1_Stack
{
	public static void main(String args[])
	{
		Stack s1 = new Stack();
		
		System.out.println("Created Stack s1.\nPrinting s1.");
		System.out.println(s1.toString());
		System.out.println("Is s1 empty?");
		if(s1.isEmpty())
			System.out.println("s1 is empty.\n");
		else
			System.out.println("s1 is not empty.\n");
		
		System.out.println("Is s1 full?");
		if(s1.isFull())
			System.out.println("s1 is full.\n");
		else
			System.out.println("s1 is not full.\n");
		
		System.out.println("Pushing 14, 11, 17, 19, 44, 5 in the stack in that order.\n");
		s1.push(14);
		s1.push(11);
		s1.push(17);
		s1.push(19);
		s1.push(44);
		s1.push(5);
		System.out.println(s1.toString());
		
		System.out.println("Popping 3 elements.");
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println("\nPeeking the top element.\n" + s1.peek() + "\n");
		System.out.println("Stack at the end.\n\n" + s1.toString());
	}
}
