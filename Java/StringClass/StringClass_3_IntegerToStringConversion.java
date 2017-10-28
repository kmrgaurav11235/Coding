import java.text.DecimalFormat;
class StringClass_3_IntegerToStringConversion
{
	public static void main(String args[])
	{
		int num1 = 1024;
		
		//static method toString of Integer class
		String str1 = Integer.toString(num1);
		System.out.println("Integer " + num1 + " converted to String " + str1 + ".");
		
		//static method valueOf of String class
		String str2 = String.valueOf(num1);
		System.out.println("Integer " + num1 + " converted to String " + str2 + ".");
		
		//Integer Object
		Integer intObj = new Integer(num1);
		String str3 = intObj.toString();
		System.out.println("Integer " + num1 + " converted to String " + str3 + ".");
		
		//Using Decimal Format
		DecimalFormat dp = new DecimalFormat("#,###");//Internal Notation. Use # for no commas
		String strFormatted = dp.format(num1);
		System.out.println("Integer " + num1 + " converted to Formatted String " + strFormatted + ".");
		
		//StringBuilder Object
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(num1);
		System.out.println("Integer " + num1 + " converted to String " + strBuild + ".");
		
		//StringBuffer Object
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(num1);
		System.out.println("Integer " + num1 + " converted to String " + strBuff + ".");
		
		//Conversion to Binary string     
		String str4 = Integer.toBinaryString(num1);
		System.out.println("Integer " + num1 + " converted to Binary String " + str4 + ".");
		
		//Conversion to Hexadecimal string     
		String str5 = Integer.toHexString(num1);
		System.out.println("Integer " + num1 + " converted to Hexadecimal String " + str5 + ".");
		
		//Conversion to Octal string     
		String str6 = Integer.toOctalString(num1);
		System.out.println("Integer " + num1 + " converted to Octal String " + str6 + ".");
		
		//Conversion to binary string     
		String str7 = Integer.toString(num1, 7);
		System.out.println("Integer " + num1 + " converted to Base 7 String " + str7 + ".");
	}
}
