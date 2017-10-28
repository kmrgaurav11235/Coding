/*
 * Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array, i.e., both stacks 
 * should use the same array for storing elements. 
 * Following functions must be supported by twoStacks.
 * 		push1(int x) –> pushes x to first stack
 * 		push2(int x) –> pushes x to second stack
 * 		pop1() –> pops an element from first stack and return the popped element
 * 		pop2() –> pops an element from second stack and return the popped element
 * 
 * Implementation of twoStack should be space efficient.
 */
class TwoStacks
{
	private int arr[];
	private int tos1;
	private int tos2;
	private int size;
	TwoStacks(int n)
	{
		arr = new int[n];
		tos1 = -1;
		tos2 = n;
		size = n;
	}
	TwoStacks()
	{
		this(10);
	}
	boolean isEmpty1()
	{
		if(tos1 == -1)
			return true;
		return false;
	}
	boolean isFull1()
	{
		if(tos1 + 1 == tos2)
			return true;
		return false;
	}
	boolean isEmpty2()
	{
		if(tos2 == size)
			return true;
		return false;
	}
	boolean isFull2()
	{
		return isFull1();
	}
	boolean push1(int data)
	{
		if(isFull1())
			return false;
		tos1++;
		arr[tos1] = data;
		return true;
	}
	boolean push2(int data)
	{
		if(isFull2())
			return false;
		tos2--;
		arr[tos2] = data;
		return true;
	}
	int pop1()
	{
		int res = 0;
		if(isEmpty1())
			return res;
		res = arr[tos1];
		tos1--;
		return res;
	}
	int pop2()
	{
		int res = 0;
		if(isEmpty2())
			return res;
		res = arr[tos2];
		tos2++;
		return res;
	}
}
class Stack_4_TwoStacksInArray
{
	public static void main(String args[])
    {
        TwoStacks ts = new TwoStacks();
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        ts.push1(18);
        ts.push2(19);
        ts.push2(72);
        ts.push1(44);
        ts.push2(11);
        ts.push1(64);//will fail
        System.out.println("Popped element from stack1 is " + ts.pop1());
        ts.push2(400);
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack1 is " + ts.pop1());
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack1 is " + ts.pop1());
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack1 is " + ts.pop1());
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack1 is " + ts.pop1());
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack2 is " + ts.pop2());
        System.out.println("Popped element from stack2 is " + ts.pop2());
    }
}
