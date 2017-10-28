//Remove all duplicate characters from a string
import java.util.HashSet;

class String_2_RemoveDuplicates
{
	static String removeDuplicates(String str)
	{
		String nonDuplicateStr = "";
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++)
		{
			String charStr = String.valueOf(str.charAt(i));
			if(!hs.contains(charStr))
			{
				hs.add(charStr);
				nonDuplicateStr = nonDuplicateStr + charStr;
			}
		}
		return nonDuplicateStr;
	}
	public static void main(String args[])
	{
		String str1 = "My name is Khan and I am not a terrorist.";
		System.out.println("Original String: " + str1);
		str1 = removeDuplicates(str1);
		System.out.println("New String after duplicate removal String: " + str1);
		
		String str2 = "geeksforgeeks";
		System.out.println("\nOriginal String: " + str2);
		str2 = removeDuplicates(str2);
		System.out.println("New String after duplicate removal String: " + str2);
	}
}
