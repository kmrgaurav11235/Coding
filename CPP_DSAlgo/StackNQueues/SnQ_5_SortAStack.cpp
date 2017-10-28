/*
Sort a stack. You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on 
Stack S: isEmpty(S), push(S), pop(S)
 */
#include <iostream>
#define MAX 100

using namespace std;

struct node
{
    int data;
    struct node *next;
};

class Stack
{
    private:
        struct node * tos;
    public:
        Stack();
        ~Stack();
        bool isEmpty();
        void push(int x);
        int pop();
        int peek();
        void display();
};

Stack::Stack()
{
    tos = NULL;
}

Stack::~Stack()
{
    struct node * temp;
    while(!isEmpty())
    {
        temp = tos;
        tos = tos -> next;
        delete temp;
    }
}
bool Stack::isEmpty()
{
    if(tos == NULL)
        return true;
    return false;
}

void Stack::push(int x)
{
    struct node * temp = new node;
    if(temp == NULL)
    {
        cout << "\nFull Stack.\n";
        return;
    }
    temp -> data = x;
    temp -> next = tos;
    tos = temp;
}

int Stack::pop()
{
    if(isEmpty())
    {
        cout << "\nEmpty Stack.\n";
        return NULL;
    }
    struct node * temp = tos;
    int x;

    tos = tos -> next;
    x = temp -> data;
    delete temp;
    return x;
}

int Stack::peek()
{
    if(isEmpty())
    {
        cout << "\nEmpty Stack.\n";
        return NULL;
    }

    int x = tos -> data;
    return x;
}

void Stack::display()
{
    if(isEmpty())
    {
        cout << "\nEmpty Stack.\n";
        return;
    }

	cout << "\nStack:\n";
    struct node *p = tos;
    
    while(p != NULL)
    {
		cout << p -> data << endl;
		p = p -> next;
	}
}

void pushAtItsPlace(Stack & s, int num)
{
	if(s.isEmpty())
	{
		s.push(num);
		return;
	}
	int curr = s.pop();
	if(curr > num)
	{
		//Push curr after num
		s.push(curr);
		s.push(num);
	}
	else
	{
		pushAtItsPlace(s, num);
		s.push(curr);
	}
}

void sortStack(Stack & s)
{
	if(s.isEmpty())
		return;
	int curr = s.pop();
	sortStack(s);
	pushAtItsPlace(s, curr);
}

int main()
{
    Stack s;

    s.push(30);
    s.push(-5);
    s.push(18);
    s.push(14);
    s.push(-3);

    cout <<"Before Sorting.";
    s.display();
    
    sortStack(s);
    
    cout <<"\nAfter Sorting.";
    s.display();

    return 0;
}


