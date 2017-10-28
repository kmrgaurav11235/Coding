/*
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. 
 * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
import java.util.Arrays;
import java.util.LinkedList;

class Array_4_LeaderOfArray
{
	static LinkedList findLeaderOfArray(int a[])
	{
		LinkedList<Integer> leaderList = new LinkedList<>();
		int index = a.length - 1;
		
		if(index == -1)
			return leaderList;
		
		int currMax = a[index];
		leaderList.add(a[index]);
		
		if(index == 0)
			return leaderList;
		
		for(int i = index - 1; i >= 0; i--)
		{
			if(currMax < a[i])
			{
				leaderList.addFirst(a[i]);
				currMax = a[i];
			}
		}
		return leaderList;
	}
	public static void main(String args[])
	{
		int a[] = {16, 17, 4, 3, 5, 2};
		
		System.out.println("Array: " + Arrays.toString(a));
		LinkedList<Integer> leaderList = findLeaderOfArray(a);
		System.out.println("Leaders: " + leaderList);
	}
}
