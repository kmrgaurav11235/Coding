import java.util.*;
class Stack_9_StockSpanProblem
{
	/*
	 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate 
	 * span of stock’s price for all n days.
	 * 
	 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day(i), 
	 * for which the price of the stock on the current day(0 ... i -1) is less than or equal to its price on the given day(i).
	 * 
	 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days 
	 * are {1, 1, 1, 2, 1, 4, 6}
	 */
	static int[] findStockSpanArray(int cost[], int n)
	{
		int stockSpan[] = new int[n];
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		stockSpan[0] = 1;
		//stockSpan value of first element is always 1
		
		for(int i = 1; i < n; i++)
		{
			//Pop elements from stack while stack is not empty and top of stack is smaller than cost[i]
			while(!st.isEmpty() && cost[st.peek()] <= cost[i])
				st.pop();
			if(st.isEmpty())
				stockSpan[i] = i + 1;
			//If stack is empty, cost[i] is greater than all elements to its left
			else
				stockSpan[i] = i - st.peek();
			//else it is greater than all elements till st.peek()
		}
		return stockSpan;
		
	}
	public static void main(String args[])
	{
		int cost1[] = {100, 80, 60, 70, 60, 75, 85};
		System.out.println("Cost Array: " + Arrays.toString(cost1));
		int stockSpan1[] = findStockSpanArray(cost1, cost1.length);
		System.out.println("Stock Span Array: " + Arrays.toString(stockSpan1));
		
		int cost2[] = {10, 4, 5, 90, 120, 80};
		System.out.println("\nCost Array: " + Arrays.toString(cost2));
		int stockSpan2[] =  findStockSpanArray(cost2, cost2.length);
		System.out.println("Stock Span Array: " + Arrays.toString(stockSpan2));
	}
}
