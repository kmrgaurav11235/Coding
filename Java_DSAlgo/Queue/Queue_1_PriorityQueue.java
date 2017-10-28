/*
 * A typical priority queue supports following operations. 
 * 		insert(item, priority): Inserts an item with given priority.
 * 		getHighestPriorityElement(): Returns the highest priority item.
 * 		deleteHighestPriorityElement(): Removes the highest priority item.
 */
import java.util.Arrays;
class Heap
{
	private final int MAX_SIZE;
	private int size;
	private int a[][];
	Heap()
	{
		this(10);
	}
	Heap(int n)
	{
		MAX_SIZE = n;
		a = new int[MAX_SIZE][2];
		size = 0;
	}
	int getSize()
	{
		return size;
	}
	boolean isFull()
	{
		if(size == MAX_SIZE)
			return true;
		return false;
	}
	boolean isEmpty()
	{
		if(size == 0)
			return true;
		return false;		
	}
	int getLChild(int index)
	{
		return (2 * index + 1);
	}
	int getRChild(int index)
	{
		return (2 * index + 2);
	}
	int getParent(int index)
	{
		return ((index - 1) / 2);
	}
	void restoreUp(int index)
	{
		if(index == 0)
			return;
		int parent = getParent(index);
		if(a[index][0] > a[parent][0])
		{
			int temp = a[index][0];
			a[index][0] = a[parent][0];
			a[parent][0] = temp;
			temp = a[index][1];
			a[index][1] = a[parent][1];
			a[parent][1] = temp;
			restoreUp(parent);
		}
	}
	void restoreDown(int index)
	{
		int biggest = index;
		int left = getLChild(index);
		int right = getRChild(index);
		if(size > left && a[left][0] > a[biggest][0])
			biggest = left;
		if(size > right && a[right][0] > a[biggest][0])
			biggest = right;
		if(index != biggest)
		{
			int temp = a[index][0];
			a[index][0] = a[biggest][0];
			a[biggest][0] = temp;
			temp = a[index][1];
			a[index][1] = a[biggest][1];
			a[biggest][1] = temp;
			restoreDown(biggest);
		}
	}
	boolean insertElement(int element, int priority)
	{
		if(isFull())
			return false;
		size++;
		a[size - 1][0] = priority;
		a[size - 1][1] = element;
		restoreUp(size - 1);
		return true;
	}
	int getMaximum()
	{
		if(isEmpty())
			return 0;
		int res = a[0][1];
		a[0][0] = a[size - 1][0];
		a[0][1] = a[size - 1][1];
		size--;
		restoreDown(0);
		return res;
	}
	int peek()
	{
		if(isEmpty())
			return 0;
		return a[0][1];
	}
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < size; i++)
			str += (a[i][0] + " -> " + a[i][1] + "\n");
		return str;
	}
}
class PriorityQueue extends Heap
{
	PriorityQueue()
	{
		this(10);
	}
	PriorityQueue(int n)
	{
		super(n);
	}
	boolean insert(int item, int priority)
	{
		return insertElement(item, priority);
	}
	int getHighestPriorityElement()
	{
		return peek();
	}
	int deleteHighestPriorityElement()
	{
		return getMaximum();
	}
}
class Queue_1_PriorityQueue
{
	public static void main(String args[])
	{
		PriorityQueue pq = new PriorityQueue();
		pq.insert(35, 2);
		pq.insert(98, 4);
		pq.insert(87, 3);
		pq.insert(58, 1);
		pq.insert(102, 4);
		
		System.out.println("Priority Queue: " + pq);
		System.out.println("getHighestPriorityElement: " + pq.getHighestPriorityElement());
		System.out.println("deleteHighestPriorityElement: " + pq.deleteHighestPriorityElement());
		System.out.println("deleteHighestPriorityElement: " + pq.deleteHighestPriorityElement());
		System.out.println("deleteHighestPriorityElement: " + pq.deleteHighestPriorityElement());
		System.out.println("deleteHighestPriorityElement: " + pq.deleteHighestPriorityElement());
		System.out.println("deleteHighestPriorityElement: " + pq.deleteHighestPriorityElement());
	}
}
/*
 * Heap is generally preferred for priority queue implementation because heaps provide better performance compared arrays or linked 
 * list. In a Binary Heap, getHighestPriority() can be implemented in O(1) time, insert() can be implemented in O(Logn) time and 
 * deleteHighestPriority() can also be implemented in O(Logn) time.
 */
