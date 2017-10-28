import java.util.*;
class Stack_3_ReverseAString
{
	static String reverseString(String str)
	{
		Deque<String> dq = new LinkedList<>();
		
		for(int i = 0; i < str.length(); i++)
		{
			String chStr = String.valueOf(str.charAt(i));
			dq.push(chStr);
		}
		str = "";
		while(!dq.isEmpty())
		{
			str = str + dq.pop(); 
		}
		return str;
	}
	public static void main(String args[])
	{
		String str = "madam i am adam";
		System.out.println("String: " + str + "\nReverseed string: " + reverseString(str));
	}
}
