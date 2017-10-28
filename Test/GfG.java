import java.util.*;
import java.lang.*;
import java.io.*;

class GfG {
    static void findNGEArray(int a[], int n, int sol[][], int t)
    {
        Deque<Integer> dq = new LinkedList<>();
        int poppedIndex = 0;
        for(int i = 0; i < n; i++)
        {
			System.out.println("i =" + i);
            if(!dq.isEmpty())
            {
				
                poppedIndex = dq.pop();
				System.out.println("poppedIndex =" + poppedIndex);
                while(a[i] > a[poppedIndex])
                {
                    sol[t][poppedIndex] = a[i];
                    if(!dq.isEmpty())
                    {
                        poppedIndex = dq.pop();
						System.out.println("is empty poppedIndex =" + poppedIndex);
					}
                    else
                        break;
                }
                if(a[i] <= a[poppedIndex])
                {
                    dq.push(poppedIndex);
					System.out.println("a[i] =" + a[i] + "a[poppedIndex] =" + a[poppedIndex]);
				}
            }//end of while(!dq.isEmpty())
            dq.push(i);
        }//end of for
        while(!dq.isEmpty())
            sol[t][dq.pop()] = -1;
		for(int j = 0; j < n; j++)
		        System.out.print(sol[t][j] + " ");
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	    System.out.println(t + " t ");
		int sol[][] = new int[t][1010];
		int n[] = new int[t];
		
		for(int i = 0; i < t; i++)
		{
		    n[i] = sc.nextInt();
			System.out.println(" n [" + i + "] = " + n[i]);
		    int a[] = new int[n[i]];
		    for(int j = 0; j < n[i]; j++)
		        a[j] = sc.nextInt();
		    for(int j = 0; j < n[i]; j++)
		        System.out.println(" a [" + j + "] = " + a[j]);
		    findNGEArray(a, n[i], sol, i);
		    for(int j = 0; j < n[i]; j++)
		        System.out.print(sol[i][j] + " ");
		}
		
		for(int i = 0; i < t; i++)
		{
		    for(int j = 0; j < n[i]; j++)
		        System.out.print(sol[i][j] + " ");
	        System.out.println();
		}
	}
}
