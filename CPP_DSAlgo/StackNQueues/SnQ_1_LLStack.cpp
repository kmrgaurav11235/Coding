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

int main()
{
    Stack s;

    s.push(10);
    s.push(20);
    s.push(30);

    cout << s.pop() << " popped from stack.\n";
    cout << s.peek() << " is the Top element.\n";

    return 0;
}
