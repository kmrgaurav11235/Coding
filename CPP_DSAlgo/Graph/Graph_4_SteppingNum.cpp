/*
Given two integers m and n, find all the stepping numbers in range [m, n]. A number is called stepping number if all adjacent digits 
have an absolute difference of 1. 321 is a Stepping Number while 421 is not.

Examples:

Input : n = 0, m = 21
Output : 0 1 2 3 4 5 6 7 8 9 10 12 21

Input : n = 10, m = 15
Output : 10, 12

*/
#include <iostream>
#define MAX 100

using namespace std;

struct node
{
    int data;
    struct node *next;
};

class Queue
{
    private:
        struct node * frontQ;
        struct node * rearQ;
    public:
        Queue();
        ~Queue();
        bool isEmpty();
        void enQueue(int x);
        int deQueue();
};

Queue::Queue()
{
    frontQ = NULL;
    rearQ = NULL;
}

Queue::~Queue()
{
    struct node * temp;
    while(frontQ != NULL)
    {
        temp = frontQ;
        frontQ = frontQ -> next;
        delete temp;
    }
}
bool Queue::isEmpty()
{
    if(frontQ == NULL && rearQ == NULL)
        return true;
    return false;
}

void Queue::enQueue(int x)
{
    struct node * temp = new node;

    if(temp == NULL)
    {
        cout << "\nFull Queue.\n";
        return;
    }

    temp -> data = x;
    temp -> next = NULL;

    if(isEmpty())
    {
        rearQ = temp;
        frontQ = temp;
    }
    else
    {
        rearQ -> next = temp;
        rearQ = temp;
    }
}

int Queue::deQueue()
{
    if(isEmpty())
    {
        cout << "\nEmpty Queue.\n";
        return NULL;
    }
    struct node * temp = frontQ;
    int x;

    frontQ = frontQ -> next;
    x = temp -> data;
    delete temp;
    if(frontQ == NULL)
        rearQ = NULL;
    return x;
}

void findSteppingNumUtil(int m, int n, int i)
{
	Queue q;
	q.enQueue(i);
	
	while(!q.isEmpty())
	{
		int num = q.deQueue();
		if(num >= m && num <= n)
			cout << num << " ";
			
		if(num == 0)
			return;
		
		int rem = num % 10;
		int firstChild = (num * 10) + (rem - 1);
		int secondChild = (num * 10) + (rem + 1);
		
		if(rem == 0)
		{
			if(secondChild <= n)
				q.enQueue(secondChild);
		}
		else if(rem == 9)
		{
			if(firstChild <= n)
				q.enQueue(firstChild);
		}
		else
		{
			if(firstChild <= n)
				q.enQueue(firstChild);
			if(secondChild <= n)
				q.enQueue(secondChild);			
		}
	}
}

void findSteppingNums(int m, int n)
{
	for(int i = 0; i < 10; i++)
		findSteppingNumUtil(m, n, i);
}

int main()
{
    int m, n;
    cout << "Finding all Stepping Numbers between given numbers m and n.\nEnter the value of m: ";
    cin >> m;
    cout << "\nEnter the value of n(n > " << m << "): ";
    cin >> n;
    
    findSteppingNums(m, n);
    
    return 0;
}

