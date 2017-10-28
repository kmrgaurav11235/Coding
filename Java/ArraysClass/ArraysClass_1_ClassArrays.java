import java.util.Arrays;
import java.util.List;
class ArraysClass_1_ClassArrays
{
	public static void main(String args[])
	{
		int arr1[] = {42, 11, 77, 16, 19, 1, -4, 87};
		int arr2[] = {42, 11, 77, 16, 19, 1, -4, 87};
		int arr3[] = {42, 11, 77, 16, 19, 1, -4, 87};
		
		/*
		 * The string representation consists of a list of the array’s elements, enclosed in square brackets (“[]”). Adjacent elements 
		 * are separated by the characters a comma followed by a space. Elements are converted to strings as by String.valueOf(int). 
		 * Returns "null" if a is null. 
		 */
		System.out.println("Arrays.toString() method:");
		System.out.println(Arrays.toString(arr1));
		
		/*
		 * public static void sort(int[] a) – Sorts the specified array into ascending numerical order.
		 */
		System.out.println("\nArrays.sort() method without extra argument:");
		System.out.println("Before: " + Arrays.toString(arr1));
		Arrays.sort(arr1);
		System.out.println("After: " + Arrays.toString(arr1));
		
		/*
		 * public static void sort(int[] a, int fromIndex, int toIndex) If we wish to sort a specified range of the array into 
		 * ascending order, we can use this. The range to be sorted extends from the index fromIndex, inclusive, to the index 
		 * toIndex, exclusive. If fromIndex == toIndex, the range to be sorted is empty. 
		 */
		System.out.println("\nArrays.sort() method for indices [3, 6):");
		System.out.println("Before: " + Arrays.toString(arr2));
		Arrays.sort(arr2, 3, 6);
		System.out.println("After: " + Arrays.toString(arr2));
		
		/*
		 * public static void fill(int[] a, int val) Fills all elements of the specified array with the specified value.
		 */
		System.out.println("\nArrays.fill() method to fill 0s:");
		System.out.println("Before: " + Arrays.toString(arr1));
		Arrays.fill(arr1, 0);
		System.out.println("After: " + Arrays.toString(arr1));
		
		/*
		 * public static void fill(int[] a, int fromIndex, int toIndex, int val) – Fills elements of the specified array with the 
		 * specified value from the fromIndex element, but not including the toIndex element. 
		 */
		System.out.println("\nArrays.fill() method to fill -7 at indices [2, 7):");
		System.out.println("Before: " + Arrays.toString(arr2));
		Arrays.fill(arr2, 2, 7, -7);
		System.out.println("After: " + Arrays.toString(arr2));
		
		/*
		 * public static int[] copyOf(int[] original, int newLength) Copies the specified array and length. It truncates the array 
		 * if provided length is smaller and pads if provided .
		 */
		System.out.println("\nArrays.copyOf() method copying less elements (5) than original array:");
		System.out.println("Before: " + Arrays.toString(arr3));
		int arr4[] = Arrays.copyOf(arr3, 5);
		System.out.println("After: " + Arrays.toString(arr4));

		System.out.println("\nArrays.copyOf() method copying more elements (12) than original array:");
		System.out.println("Before: " + Arrays.toString(arr3));
		int arr5[] = Arrays.copyOf(arr3, 12);
		System.out.println("After: " + Arrays.toString(arr5));
		
		/*
		 * public static int[] copyOfRange(int[] original, int from, int to) Copies the specified range of the specified array 
		 * into a new array. The initial index of the range (from) must lie between zero and original.length, inclusive. 
		 */		
		System.out.println("\nArrays.copyOfRange() method copying elements [2, 6) :");
		System.out.println("Before: " + Arrays.toString(arr3));
		int arr6[] = Arrays.copyOfRange(arr3, 2, 6);
		System.out.println("After: " + Arrays.toString(arr6));
		
		/*
		 * public static int binarySearch(int[] a, int key) Returns an int value for the index of the specified key in the specified 
		 * array. Returns a negative number if the specified key is not found in the array. For this method to work properly, the 
		 * array must first be sorted by the sort method. 
		 */
		Arrays.sort(arr3);
		System.out.println("\nArrays.binarySearch() method:");
		System.out.println("Array: " + Arrays.toString(arr3));
		System.out.println("Index of -4: " + Arrays.binarySearch(arr3, -4));
		System.out.println("Index of 87: " + Arrays.binarySearch(arr3, 87));
		System.out.println("Index of 11: " + Arrays.binarySearch(arr3, 11));
		System.out.println("Index of -6: " + Arrays.binarySearch(arr3, -6));
		System.out.println("Index of 65: " + Arrays.binarySearch(arr3, 65));
		System.out.println("Index of 191: " + Arrays.binarySearch(arr3, 191));
		
		/*
		 * public static List asList(T… a) It takes an array and creates a wrapper that implements List, which makes the original array 
		 * available as a list. Nothing is copied and all, only a single wrapper object is created. Operations on the list wrapper 
		 * are propagated to the original array. This means that if you shuffle the list wrapper, the original array is shuffled as 
		 * well, if you overwrite an element, it gets overwritten in the original array, etc. Of course, some List operations aren’t 
		 * allowed on the wrapper, like adding or removing elements from the list, you can only read or overwrite the elements.
		 */
		Integer arr7[] = {42, 11, 77, 16, 19, 1, -4, 87};
		System.out.println("\nArrays.asList() method:");
		System.out.println("Array: " + Arrays.toString(arr7));
		System.out.print("List: ");
		List<Integer> list = Arrays.asList(arr7);
		for(Integer i:list)
			System.out.print(i + " ");
		System.out.println();
	}
}
