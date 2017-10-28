class ArrayOperations
{
	private final int MAX_VAL;
	private int currSize;
	ArrayOperations(int a[], int maxSize)
	{
		MAX_VAL = maxSize;
		currSize = MAX_VAL / 2;	
		for(int i = 0; i < MAX_VAL/2; i++)
			a[i] = i;
	}
	public void display(int a[])
	{
		for(int i = 0; i < currSize; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public int search(int a[], int key)
	{
		for(int i = 0; i < currSize; i++)
			if(a[i] == key)
				return i;
		return -1;
	}
	public boolean insert(int a[], int data)
	{
		if(currSize == MAX_VAL)
			return false;
		a[currSize] = data;
		currSize++;
		return true;
	}
	public boolean delete(int a[], int key)
	{
		int index = search(a, key);
		if(index == -1)
			return false;
		currSize--;
		for(int i = index; i < currSize; i++)
			a[i] = a[i + 1];
		return true;
	}
}
class Array_1_SearchInsertDeleteInUnsorted
{
	public static void main(String args[])
	{
		int maxSize = 20;
		int a[] = new int[maxSize];
		ArrayOperations ao = new ArrayOperations(a, maxSize);
		
		System.out.println("Array:");
		ao.display(a);
		
		int res;
		
		System.out.println("\nSearching for 15 in Array.");
		res = ao.search(a, 15);
		if(res != -1)
			System.out.println("Element 15 found at index: " + res);
		else
			System.out.println("Element 15 not found in array.");
		
		System.out.println("\nSearching for 7 in Array.");
		res = ao.search(a, 7);
		if(res != -1)
			System.out.println("Element 7 found at index: " + res);
		else
			System.out.println("Element 7 not found in array.");
		
		System.out.println("\nArray:");
		ao.display(a);
		System.out.println("\nInserting for 15 in Array.");
		if(ao.insert(a, 15))
			System.out.println("Element 15 inserted in array.");
		else
			System.out.println("Element 15 not inserted in array. Array is full.");
		
		System.out.println("\nArray:");
		ao.display(a);
		System.out.println("\nInserting for 19 in Array.");
		if(ao.insert(a, 19))
			System.out.println("Element 19 inserted in array.");
		else
			System.out.println("Element 19 not inserted in array. Array is full.");
		
		System.out.println("\nArray:");
		ao.display(a);
		System.out.println("\nDeleting for 0 in Array.");
		if(ao.delete(a, 0))
			System.out.println("Element 0 was deleted from array.");
		else
			System.out.println("Element 0 not found and thus, not deleted from array.");
		
		System.out.println("\nArray:");
		ao.display(a);
		System.out.println("\nDeleting for 4 in Array.");
		if(ao.delete(a, 4))
			System.out.println("Element 4 was deleted from array.");
		else
			System.out.println("Element 4 not found and thus, not deleted from array.");
		
		System.out.println("\nArray:");
		ao.display(a);
		System.out.println("\nDeleting for 19 in Array.");
		if(ao.delete(a, 19))
			System.out.println("Element 19 was deleted from array.");
		else
			System.out.println("Element 19 not found and thus, not deleted from array.");
		
		System.out.println("Array:");
		ao.display(a);
	}
}
