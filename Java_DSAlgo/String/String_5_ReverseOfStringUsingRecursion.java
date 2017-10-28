class String_5_ReverseOfStringUsingRecursion
{
	static String reverseString(String str, int index)
	{
		if(index == str.length())
			return "";
		String charStr = String.valueOf(str.charAt(index));
		String revStr = reverseString(str, index + 1);
		return (revStr + charStr);
	}
	public static void main(String args[])
	{
		String str1 = "My name is Khan and I am not a terrorist.";
		System.out.println("Original String: " + str1);
		str1 = reverseString(str1, 0);
		System.out.println("Reversed String: " + str1);
		
		String str2 = "madam i m adam";
		System.out.println("Original String: " + str2);
		str2 = reverseString(str2, 0);
		System.out.println("Reversed String: " + str2);
	}
}
