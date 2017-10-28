/*
 * Input  : s = "getting good at coding needs a lot of practice"
 * Output : s = "practice of lot a needs coding at good getting"
 */
class String_6_ReverseWords
{
	static String reverse(String str)
	{
		String strFirst = "", strLast = "";
		int start = 0, end = str.length() - 1;

		while(start <= end)
		{
			if(start == end)
			{
				strFirst = strFirst + String.valueOf(str.charAt(end));
			}
			else
			{
				strFirst = strFirst + String.valueOf(str.charAt(end));
				strLast = String.valueOf(str.charAt(start)) + strLast;
			}
			start++;
			end--;
		}
		str = strFirst + strLast;
		return str;
	}

	static String reverseWords(String str)
	{
		String [] strArr = str.split(" ");

		for(int i = 0; i < strArr.length; i++)
		{
			strArr[i] = reverse(strArr[i]);
			//str = str + strArr[i] + " ";
		}
		
		str = "";
		for(int i = strArr.length - 1; i >= 0 ; i--)
		{
			strArr[i] = reverse(strArr[i]);
			str = str + strArr[i] + " ";
		}
		
		return str;
	}
	public static void main(String args[])
	{
		String str1 = "My name is   Khan and I am not a terrorist";
		System.out.println("Original String: " + str1);
		str1 = reverseWords(str1);
		System.out.println("Reversed String: " + str1);
		
		String str2 = "getting good at coding needs a lot of practice";
		System.out.println("\nOriginal String: " + str2);
		str2 = reverseWords(str2);
		System.out.println("Reversed String: " + str2);
	}
}
