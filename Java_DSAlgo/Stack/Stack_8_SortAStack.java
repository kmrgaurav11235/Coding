/*
 * Sort a stack using recursion
 * You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
 * 		isEmpty(S)
 * 		push(S)
 * 		pop(S)
 * 		peek(S)
 */
import java.util.*;
class Stack_8_SortAStack
{
	static void insertAtItsPlace(Deque<Integer> dq, int item)
	{
		if(dq.isEmpty())
		{
			dq.push(item);
			return;
		}
		int temp = dq.pop();
		if(temp < item)
		{
			insertAtItsPlace(dq, item);
			dq.push(temp);
		}
		else
		{
			dq.push(temp);
			dq.push(item);
		}
	}
	static void sortStack(Deque<Integer> dq)
	{
		if(dq.isEmpty())
			return;
		int item = dq.pop();
		sortStack(dq);
		insertAtItsPlace(dq, item);
	}
	public static void main(String args[])
	{
		Deque<Integer> dq = new LinkedList<>();
		dq.push(14);
		dq.push(91);
		dq.push(18);
		dq.push(7);
		dq.push(64);
		dq.push(5);
		
		System.out.println("Original Stack: " + dq);
		sortStack(dq);
		System.out.println("Sorted Stack: " + dq);
	}
	/*
	 * This problem is mainly a variant of Reverse stack using recursion.
	 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. When the stack becomes empty, 
	 * insert all held items one by one in sorted order. Here sorted order is important.
	 */
}
