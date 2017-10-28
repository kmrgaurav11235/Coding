//Remove characters from the first string which are present in the second string
import java.util.HashSet;
class String_3_RemoveCharsFromStringPresentInAnother
{
    static String removeCharsFromStringPresentInAnother(String str1, String str2)
    {
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < str2.length(); i++)
		{
			String charStr = String.valueOf(str2.charAt(i));
			hs.add(charStr);
		}
		
		String newStr = "";
		for(int i = 0; i < str1.length(); i++)
		{
			String charStr = String.valueOf(str1.charAt(i));
			if(!hs.contains(charStr))
			{
				newStr = newStr + charStr;
			}
		}
		return newStr;
	}
    public static void main(String args[])
    {
		String str1 = "geeksforgeeks";
		String str2 = "mask";
		System.out.println("Original Strings: \nStr1 = " + str1 + "\nStr2 = " + str2);
		str1 = removeCharsFromStringPresentInAnother(str1, str2);
		System.out.println("Str1 - Str2 = " + str1);
    }
}
