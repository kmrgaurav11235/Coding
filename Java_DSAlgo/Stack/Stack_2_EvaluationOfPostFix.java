import java.util.*;
class Stack_2_EvaluationOfPostFix
{
	static boolean isNumber(char ch)
	{
		if(ch >= '0' && ch <= '9')
			return true;
		return false;
	}
	static int evaluateExpression(int a, int b, char operator)
	{
		if(operator == '+')
			return (a + b);
		else if(operator == '-')
			return (a - b);
		else if(operator == '*')
			return (a * b);
		else if(operator == '/')
			return (a / b);
		else if(operator == '%')
			return (a % b);
		else if(operator == '^')
			return (a ^ b);
		else
			return 0;
	}
	static int evaluatePostfix(String exp)
	{
		int result = 0;
		Deque<Integer> dq = new LinkedList<>();
		for(int i = 0; i < exp.length(); i++)
		{
			char ch = exp.charAt(i);
			if(isNumber(ch))
			{
				dq.push((int)(ch - '0'));
			}
			else
			{
				int b = dq.pop();
				int a = dq.pop();
				int res = evaluateExpression(a, b, ch);
				dq.push(res);
			}
		}
		result = dq.pop();
		if(dq.isEmpty())
			return result;
		else
			return 0;
	}
	public static void main(String args[])
	{
		String exp = "231*+9-";
		System.out.println("Postfix expression: " + exp + "\nValue of expression is: " + evaluatePostfix(exp));
	}
}
/*
 * Algorithm for evaluation postfix expressions:
 * 1) Create a stack to store operands (or values).
 * 2) Scan the given expression and do following for every scanned element.
 * 		a) If the element is a number, push it into the stack
 * 		b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back 
 * 			to the stack
 * 3) When the expression is ended, the number in the stack is the final answer
 */
