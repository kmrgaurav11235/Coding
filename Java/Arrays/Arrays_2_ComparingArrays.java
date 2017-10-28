import java.util.*;
class Arrays_2_ComparingArrays
{
	public static void main(String args[])
	{
		int arr1[] = {1, 150, 289, 873, 5, 98, 213, 21};
		int arr2[] = {1, 150, 289, 873, 5, 98, 213, 21};
		
		System.out.println("Method 1: Simple comparision.");
		if(arr1 == arr2)
			System.out.println("Arr1 equals Arr2.\n");
		else
			System.out.println("Arr1 not equals Arr2.\n");
		/*
		 * In Java, arrays are first class objects. arr1 and arr2 are two references to two different objects. So when we compare 
		 * arr1 and arr2, two reference variables are compared, therefore we get the output as "Arr1 not equals Arr2".
		 */
		
		System.out.println("Method 2: Static method \"Arrays.equals\".");
		if(Arrays.equals(arr1, arr2))
			System.out.println("Arr1 equals Arr2.\n");
		else
			System.out.println("Arr1 not equals Arr2.\n");
		//Java provides a direct method Arrays.equals() to compare two arrays.
		
		Object inOb1[] = {arr1};
		Object inOb2[] = {arr2};
		
		System.out.println("Method 2: Static method \"Arrays.equals\" on deep array.");
		if(Arrays.equals(inOb1, inOb2))
			System.out.println("inOb1 equals inOb2.\n");
		else
			System.out.println("inOb1 not equals inOb2.\n");
		/*
		 * What if the arrays contain arrays inside them or some other references which refer to different object but have same values?
		 * Arrays.equals() is not able to do deep comparison, therefore we get the output as "Arr1 not equals Arr2". 
		 */
		
		System.out.println("Method 3: Static method \"Arrays.deepEquals\" on deep array.");
		if(Arrays.deepEquals(inOb1, inOb2))
			System.out.println("inOb1 equals inOb2.\n");
		else
			System.out.println("inOb1 not equals inOb2.\n");
		
		Object outOb1[] = {inOb1};
		Object outOb2[] = {inOb2};
		
		System.out.println("Method 3: Static method \"Arrays.deepEquals\" on deeper array.");
		if(Arrays.deepEquals(inOb1, inOb2))
			System.out.println("outOb1 equals outOb2.\n");
		else
			System.out.println("outOb1 not equals outOb2.\n");
		/*
		 * How does Arrays.deepEquals() work?
		 * It compares two objects using any custom equals() methods they may have (if they have an equals() method implemented 
		 * other than Object.equals()). If not, this method will then proceed to compare the objects field by field, recursively. 
		 * As each field is encountered, it will attempt to use the derived equals() if it exists, otherwise it will continue to 
		 * recurse further. This method works on a cyclic Object graph like this: A->B->C->A. It has cycle detection so ANY two 
		 * objects can be compared, and it will never enter into an endless loop.
		 */
	}
}
