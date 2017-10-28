class SortedArrayOperations
{
	private final int MAX_VAL;
	private int currSize;
	SortedArrayOperations(int a[], int maxSize)
	{
		MAX_VAL = maxSize;
		currSize = MAX_VAL / 2;	
		for(int i = 0; i < MAX_VAL/2; i++)
			a[i] = i;
	}
	public int getSize()
	{
		return currSize;
	}
	public void display(int a[])
	{
		for(int i = 0; i < currSize; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public int binarySearch(int a[], int key, int low, int high)
	{
		if(low > high)
			return -1;
		int mid = (low + high) / 2;
		if(a[mid] == key)
			return mid;
		else if(a[mid] > key)
			return binarySearch(a, key, low, mid - 1);
		else
			return binarySearch(a, key, mid + 1, high);
		
	}
	public boolean insert(int a[], int data)
	{
		if(currSize == MAX_VAL)
			return false;
		int i;
		for(i = currSize; (i > 0) && a[i - 1] > data; i--)
			a[i] = a[i - 1];
		a[i] = data;
		currSize++;
		return true;
	}
	public boolean delete(int a[], int key)
	{
		int index = binarySearch(a, key, 0, currSize);
		if(index == -1)
			return false;
		currSize--;
		for(int i = index; i < currSize; i++)
			a[i] = a[i + 1];
		return true;
	}
}
class Array_2_SearchInsertDeleteInSorted
{
	public static void main(String args[])
	{
		int maxSize = 20;
		int a[] = new int[maxSize];
		SortedArrayOperations sao = new SortedArrayOperations(a, maxSize);
		
		System.out.println("Array:");
		sao.display(a);
		
		int res;
		
		System.out.println("\nSearching for 15 in Array.");
		res = sao.binarySearch(a, 15, 0, sao.getSize());
		if(res != -1)
			System.out.println("Element 15 found at index: " + res);
		else
			System.out.println("Element 15 not found in array.");
		
		System.out.println("\nSearching for 7 in Array.");
		res = sao.binarySearch(a, 7, 0, sao.getSize());
		if(res != -1)
			System.out.println("Element 7 found at index: " + res);
		else
			System.out.println("Element 7 not found in array.");
		
		System.out.println("\nSearching for 0 in Array.");
		res = sao.binarySearch(a, 0, 0, sao.getSize());
		if(res != -1)
			System.out.println("Element 0 found at index: " + res);
		else
			System.out.println("Element 0 not found in array.");
		
		System.out.println("\nSearching for -1 in Array.");
		res = sao.binarySearch(a, -1, 0, sao.getSize());
		if(res != -1)
			System.out.println("Element -1 found at index: " + res);
		else
			System.out.println("Element -1 not found in array.");
		
		System.out.println("\nSearching for 9 in Array.");
		res = sao.binarySearch(a, 9, 0, sao.getSize());
		if(res != -1)
			System.out.println("Element 9 found at index: " + res);
		else
			System.out.println("Element 9 not found in array.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nInserting for 15 in Array.");
		if(sao.insert(a, 15))
			System.out.println("Element 15 inserted in array.");
		else
			System.out.println("Element 15 not inserted in array. Array is full.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nInserting for 19 in Array.");
		if(sao.insert(a, 19))
			System.out.println("Element 19 inserted in array.");
		else
			System.out.println("Element 19 not inserted in array. Array is full.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nDeleting for 0 in Array.");
		if(sao.delete(a, 0))
			System.out.println("Element 0 was deleted from array.");
		else
			System.out.println("Element 0 not found and thus, not deleted from array.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nDeleting for 4 in Array.");
		if(sao.delete(a, 4))
			System.out.println("Element 4 was deleted from array.");
		else
			System.out.println("Element 4 not found and thus, not deleted from array.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nDeleting for 19 in Array.");
		if(sao.delete(a, 19))
			System.out.println("Element 19 was deleted from array.");
		else
			System.out.println("Element 19 not found and thus, not deleted from array.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nInserting for 4 in Array.");
		if(sao.insert(a, 4))
			System.out.println("Element 4 inserted in array.");
		else
			System.out.println("Element 4 not inserted in array. Array is full.");
		
		System.out.println("\nArray:");
		sao.display(a);
		System.out.println("\nInserting for -1 in Array.");
		if(sao.insert(a, -1))
			System.out.println("Element -1 inserted in array.");
		else
			System.out.println("Element -1 not inserted in array. Array is full.");
		
		System.out.println("Array:");
		sao.display(a);
	}
}

