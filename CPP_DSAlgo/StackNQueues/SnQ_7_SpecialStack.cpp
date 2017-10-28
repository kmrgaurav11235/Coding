/*
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an 
additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack
must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like 
arrays, list, .. etc.

Example:

Consider the following SpecialStack
16  --> TOP
15
29
19
18

When getMin() is called it should return 15, which is the minimum 
element in the current stack. 

If we do pop two times on stack, the stack becomes
29  --> TOP
19
18

When getMin() is called, it should return 18 which is the minimum 
in the current stack.

*/
#include <iostream>

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

class SpecialStack : public Stack
{
	private:
		Stack minStack;
	public:
        void push(int x);
        int pop();
		int getMin();
};

void SpecialStack::push(int x)
{
	if(Stack::isEmpty())
	{
		Stack::push(x);
		minStack.push(x);
		return;
	}
	
	Stack::push(x);
	int temp = minStack.peek();
	if(x < temp)
		minStack.push(x);
	else
		minStack.push(temp);
}

int SpecialStack::pop()
{
	int x = Stack::pop();
	minStack.pop();
	return x;
}

int SpecialStack::getMin()
{
	return minStack.peek();
}

int main()
{
    SpecialStack s;
    
    s.push(10);
    s.push(20);
    s.push(30);
    cout<<s.getMin()<<endl;
    s.push(5);
    cout<<s.getMin();

    return 0;
}

