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

int main()
{
    Queue q;

    q.enQueue(10);
    q.enQueue(20);
    q.enQueue(30);

    cout << q.deQueue() << " dequeued from Queue.\n";
    cout << q.deQueue() << " dequeued from Queue.\n";

    return 0;
}
