import java.util.ArrayList;
class Arrays_7_ArrayListToArray
{
	public static void main(String args[])
	{
		ArrayList<String> song = new ArrayList<>();
		song.add("Oh");
		song.add("I");
		song.add("just");
		song.add("cannot");
		song.add("wait");
		song.add("to");
		song.add("be");
		song.add("king!");
		
		System.out.println("Method 1: Using no argument toArray method. This return 'Object' type.");
		Object songArr1[] = song.toArray();
		for(Object str: songArr1)
			System.out.print(str + " ");
		System.out.println("\n");
		/*
		 * public Object[] toArray() 
		 * --> It is specified by toArray in interface Collection and interface List.
		 * --> It overrides toArray in class AbstractCollection.
		 * --> It returns an array containing all of the elements in this list in the correct order.
		 * 
		 * toArray() method returns an array of type Object(Object[]). We need to typecast it to Integer before using as Integer 
		 * objects. If we do not typecast, we get compilation error.
		 */

		
		System.out.println("Method 2: Using toArray method with an Array as parameter.");
		String songArr2[] = new String[song.size()];
		song.toArray(songArr2);
		for(String str: songArr2)
			System.out.print(str + " ");
		System.out.println("\n");
		/*
		 * public  T[] toArray(T[] arr)
		 * Note that the there is an array parameter and array return value. The main purpose of passed array is to tell the 
		 * type of array. The returned array is of same type as passed array. 
		 * --> If the passed array has enough space, then elements are stored in this array itself. If the passed array doesn’t have 
		 * 		enough space, a new array is created with same type and size of given list. 
		 * --> If the passed array has more space, the array is first filled with list elements, then null values are filled. 
		 * -->  If the specified array is null then it will throw NullpointerException.
		 */
		
		System.out.println("Method 3: Manual.");
		String songArr3[] = new String[song.size()];
		
		for(int i = 0; i < song.size(); i++)
			songArr3[i] = song.get(i);
			
		for(String str: songArr3)
			System.out.print(str + " ");
		System.out.println("\n");
	}
}
