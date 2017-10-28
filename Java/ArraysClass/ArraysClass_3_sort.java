import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class StudentDetails
{
	int rollNum;
	String name;
	int age;
	
	StudentDetails(int rollNum, String name, int age)
	{
		this.rollNum = rollNum;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		return ("Name: " + name + ", Roll Num: " + rollNum + ", Age: " + age + "\n");
	}
}

class sortByRollNum implements Comparator <StudentDetails>
{
	public int compare(StudentDetails sd1, StudentDetails sd2)
	{
		return (sd1.rollNum - sd2.rollNum);
	}
}

class ArraysClass_3_sort
{
	public static void main(String args[])
	{
		int arr1[] = {42, 11, 77, 16, 19, 1, -4, 87};
		System.out.println("Original Array:" + Arrays.toString(arr1));
		Arrays.sort(arr1);
		System.out.println("Sorted Array:" + Arrays.toString(arr1));
		
		//Note that we have Integer[] here instead of int[] as Collections.reverseOrder doesn't work for primitive types.
		Integer arr2[] = {42, 11, 77, 16, 19, 1, -4, 87};
		System.out.println("\nOriginal Array:" + Arrays.toString(arr2));
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println("Reverse-sorted Array:" + Arrays.toString(arr2));
		
		StudentDetails sdArray[] = {
				new StudentDetails(91, "Morpheus", 42),
				new StudentDetails(52, "Trinity", 26),
				new StudentDetails(23, "Neo", 27),
				new StudentDetails(74, "Switch", 33)
			};
		//We use Comparator interface for the purpose of Sorting user defined types.
		System.out.println("\nOriginal Array:\n" + Arrays.toString(sdArray));
		Arrays.sort(sdArray, new sortByRollNum());
		System.out.println("Array Sorted by Roll Num:\n" + Arrays.toString(sdArray));
	}
}
