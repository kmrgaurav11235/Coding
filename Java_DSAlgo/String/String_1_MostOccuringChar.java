/*
 *Return most occurring character in the input string e.g., if input string is “test” then function should return ‘t’.
 */
class String_1_MostOccuringChar
{
	static char findMostOccuringCharacter(String str)
	{
		int a[] = new int[256];
		int maxCount = 0;
		char maxChar = '-';
		for(int i = 0; i < str.length(); i++)
		{
			int index = (int)(str.charAt(i));
			a[index]++;
			if(a[index] > maxCount)
			{
				maxCount = a[index];
				maxChar = (char)(index);
			}
		}
		return maxChar;
	}
	public static void main(String args[])
	{
		String str1 = "cbbbbccc";
		System.out.println("For String '" + str1 + "', most occuring character is: " 
							+ findMostOccuringCharacter(str1) + ".");
		
		String str2 = "test sample";
		System.out.println("For String '" + str2 + "', most occuring character is: " 
							+ findMostOccuringCharacter(str2) + ".");
	}
}
