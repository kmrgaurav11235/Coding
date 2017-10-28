/*
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1.
 * (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
class String_4_AreRotations
{
	static boolean areRotations(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		String temp = str1 + str1;
		if(temp.indexOf(str2) >= 0)
			return true;
		return false;
	}
	public static void main(String args[])
	{
		String str1 = "ABCD";
		String str2 = "CDAB";
		System.out.println("Strings: \nStr1 = " + str1 + "\nStr2 = " + str2);
		System.out.println("Are Str1 and Str2 rotaions of each other? " + areRotations(str1, str2));
		
		String str3 = "ABCD";
		String str4 = "ACBD";
		System.out.println("\nStrings: \nStr3 = " + str3 + "\nStr4 = " + str4);
		System.out.println("Are Str3 and Str4 rotaions of each other? " + areRotations(str3, str4));
	}
}
/*
 * Solution:
 * 		1. Check if Strings are of equal lengths
 *		2. Create a temp string and store concatenation of str1 to str1 in temp.
 *                          temp = str1.str1
 * 		3. If str2 is a substring of temp then str1 and str2 are rotations of each other.
 */
