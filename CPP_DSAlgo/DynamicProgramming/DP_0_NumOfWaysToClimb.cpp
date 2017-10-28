/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. 
Count the number of ways, the person can reach the top.
*/
#include <iostream>

using namespace std;

int stairsProblem (int n)
{
	int a = 1;//Num of ways to climb 1 stair
	int b = 2;//Num of ways to climb 2 stairs
	int c;
	
	for(int i = 3; i <= n; i++)
	{
		c = a + b;
		a = b;
		b = c;
	}
	return c;
}

int main()
{
	int n;
    cout << "Number of to climb the stairs problem.\nWe start from stair 1 and have to reach stair n.\nEnter n: " << endl;
    cin >> n;
	int noOfWays = stairsProblem(n);
	cout << "Number of to climb the stairs  = " << noOfWays << endl;
	return 0;
}
