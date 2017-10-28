/*
 * Reverse a stack using recursion
 * You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
 * 		isEmpty(S)
 * 		push(S)
 * 		pop(S)
 */
import java.util.*;
class Stack_7_ReverseAStack
{
	static void insertAtBottom(Deque<Integer> dq, int item)
	{
		if(dq.isEmpty())
		{
			dq.push(item);
			return;
		}
		
		int temp = dq.pop();
		insertAtBottom(dq, item);
		dq.push(temp);
	}
	static void reverseStack(Deque<Integer> dq)
	{
		if(dq.isEmpty())
			return;
		
		int item = dq.pop();
		reverseStack(dq);
		insertAtBottom(dq, item);
	}
	public static void main(String args[])
	{
		Deque<Integer> dq = new LinkedList<>();
		dq.push(10);
		dq.push(9);
		dq.push(8);
		dq.push(7);
		dq.push(6);
		dq.push(5);
		
		System.out.println("Original Stack: " + dq);
		reverseStack(dq);
		System.out.println("Reversed Stack: " + dq);
	}
	/*
	 * Algorithm:
	 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. When the stack becomes empty, 
	 * insert all held items one by one at the bottom of the stack.
	 * 
	 * For example, let the input stack be
	 *     1  <-- top
	 *     2
	 *     3
	 *     4
	 * First 4 is inserted at the bottom.
	 *     4 <-- top
	 * Then 3 is inserted at the bottom
	 *     4 <-- top    
	 *     3
	 * Then 2 is inserted at the bottom
	 *     4 <-- top
	 *     3 
	 *     2
	 * Then 1 is inserted at the bottom
	 *     4 <-- top
	 *     3 
	 *     2
	 *     1
	 * 
	 * So we need a function that inserts at the bottom of a stack using the above given basic stack function.
	 * 
	 * void insertAtBottom(): First pops all stack items and stores the popped item in function call stack using recursion. And when 
	 * stack becomes empty, pushes new item and all items stored in call stack.
	 * 
	 * void reverseStack(): This function mainly uses insertAtBottom() to pop all items one by one and insert the popped items at 
	 * the bottom.
	 */
}
