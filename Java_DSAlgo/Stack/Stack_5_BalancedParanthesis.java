/*
 * Given an expression string exp , write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct 
 * in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 */
import java.util.*;
class Stack_5_BalancedParanthesis
{
    static boolean isMatch(String str1, String str2)
    {
        if(
            ((")").equals(str1) && ("(").equals(str2)) ||
            (("}").equals(str1) && ("{").equals(str2)) ||
            (("]").equals(str1) && ("[").equals(str2))
            )
            return true;
        return false;
    }
    static String checkIfBalanced(String str)
    {
        Deque<String> dq = new LinkedList<>();
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            String chStr = String.valueOf(ch);
            
            if(ch == '(' || ch == '{' || ch == '[')
                dq.push(chStr);
            else if(ch == ')' || ch == '}' || ch == ']')
            {
                if(dq.isEmpty() || !isMatch(chStr, dq.pop()))
                    return "not balanced";
            }
        }
        if(dq.isEmpty())
            return "balanced";
        else
            return "not balanced";
    }
	public static void main (String[] args) 
	{
		String str1 = "{([])}";
		System.out.println("Expression: " + str1 + "\nBalanced or not? " + checkIfBalanced(str1));
		
		String str2 = "()";
		System.out.println("\nExpression: " + str2 + "\nBalanced or not? " + checkIfBalanced(str2));
		
		String str3 = "()[]";
		System.out.println("\nExpression: " + str3 + "\nBalanced or not? " + checkIfBalanced(str3));
		
		String str4 = "[(])";
		System.out.println("\nExpression: " + str4 + "\nBalanced or not? " + checkIfBalanced(str4));
		
	}
}
/*
 * Algorithm:
 * 1) Declare a character stack S.
 * 2) Now traverse the expression string exp.
 *     a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
 *     b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the
 * 		  matching starting bracket then fine else parenthesis are not balanced.
 * 3) After complete traversal, if there is some starting bracket left in stack then “not balanced”
 */
