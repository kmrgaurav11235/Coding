import java.util.StringTokenizer;
class StringClass_8_StringTokenizer
{
	public static void main(String args[])
	{
		/*
		StringTokenizer class in Java is used to break a string into tokens. 
		A StringTokenizer object internally maintains a current position within the string to be tokenized. Some operations advance 
		this current position past the characters processed. A token is returned by taking a substring of the string that was used 
		to create the StringTokenizer object.
		
		Constructors:
		--> StringTokenizer(String str) : str is string to be tokenized. Considers default delimiters like new line, space, 
				tab, carriage return and form feed.
		--> StringTokenizer(String str, String delim) : delim is set of delimiters that are used to tokenize the given string.
		--> StringTokenizer(String str, String delim, boolean flag) : The first two parameters have same meaning.  The flag serves 
				following purpose.
				-> If the flag is false, delimiter characters serve to separate tokens. For example, if string is "hello geeks" 
					and delimiter is " ", then tokens are "hello" and "geeks".
				-> If the flag is true, delimiter characters are considered to be tokens. For example, if string is "hello geeks" 
					and delimiter is " ", then tokens are "hello", " " and "geeks".

		 */
		String str1 = "G@rb@ge  In  G@rb@ge  Out!!";
		String str2 = "G@rb@ge@@In@@G@rb@ge@@Out!!";
		
		System.out.println("String 1: " + str1);
		System.out.println("String 2: " + str2);
		System.out.println("\nStringTokenizer st1 = new StringTokenizer(str1);");
		StringTokenizer st1 = new StringTokenizer(str1);
		while(st1.hasMoreTokens())
		{
			System.out.println(st1.nextToken());
		}
		
		System.out.println("\nStringTokenizer st2 = new StringTokenizer(str1, \"@\");");
		StringTokenizer st2 = new StringTokenizer(str1, "@");
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}		
		
		System.out.println("\nStringTokenizer st3 = new StringTokenizer(str2, \"@\");");
		StringTokenizer st3 = new StringTokenizer(str2, "@");
		while(st3.hasMoreTokens())
		{
			System.out.println(st3.nextToken());
		}
		
		System.out.println("\nStringTokenizer st4 = new StringTokenizer(str1, \" \", true);");
		StringTokenizer st4 = new StringTokenizer(str1, " ", true);
		while(st4.hasMoreTokens())
		{
			System.out.println(st4.nextToken());
		}		
		
		System.out.println("\nStringTokenizer st5 = new StringTokenizer(str1, \"@\", true);");
		StringTokenizer st5 = new StringTokenizer(str1, "@", true);
		while(st5.hasMoreTokens())
		{
			System.out.println(st5.nextToken());
		}	
		
		System.out.println("\nStringTokenizer st6 = new StringTokenizer(str2, \"@\", true);");
		StringTokenizer st6 = new StringTokenizer(str2, "@", true);
		while(st6.hasMoreTokens())
		{
			System.out.println(st6.nextToken());
		}
	}
}
