import java.util.*;
class SpecialStack<E> extends Stack<E>
{
	private Stack<E> minStack;
	SpecialStack()
	{
		super();
		minStack = new Stack<E>();
	}
	@Override
	public E push(E data)
	{
		E temp = super.push(data);
		if(super.peek().equals(data))
			minStack.push(data);
		else
			minStack.push(super.peek());		
		return temp;
	}
	@Override
	public E pop()
	{
		E temp = super.pop();
		minStack.pop();
		return temp;
	}
	@Override
	public E peek()
	{
		E temp = super.peek();
		return temp;
	}
	public E getMin()
	{
		E temp = minStack.peek();
		return temp;
	}
	@Override
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
}
class Stack_10_SpecialStack
{
	public static void main(String args[])
	{
		SpecialStack<Integer> s = new SpecialStack<Integer>();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println("Stack: " + s);
		System.out.println("Minimum Element: " + s.getMin());
		s.push(5);
		System.out.println("Stack: " + s);
		System.out.println("Minimum Element: " + s.getMin());
	}
}
