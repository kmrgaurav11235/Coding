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

void bfs(bool adj[][MAX], int n, int indx, int state[])
{
    Queue q;
    int vertex, i;

    q.enQueue(indx);
    state[indx] = 0;//Working

    while(!q.isEmpty())
    {
        vertex = q.deQueue();
        state[vertex] = 1;//Traversed
        cout << vertex << " ";

        for(i = 0; i < n; i++)
        {
            if(adj[vertex][i] && state[i] == -1)
            {
                q.enQueue(i);
                state[i] = 0;
            }
        }
    }
    cout << endl;
}

void breadthFirstTraversal(bool adj[][MAX], int n)
{
    int state[MAX];
    int i;

    for(i = 0; i < n; i++)
        state[i] = -1;//Initialized

    bfs(adj, n, 0, state);

    for(i = 0; i < n; i++)
    {
        if(state[i] == -1)
            bfs(adj, n, i, state);
    }
}

int main()
{
    bool adj[MAX][MAX];
    int n;

    //Initializattion
    n = 9;
    adj[0][0] = false; adj[0][1] =  true; adj[0][2] = false; adj[0][3] =  true; adj[0][4] =  true; adj[0][5] = false; adj[0][6] = false; adj[0][7] = false; adj[0][8] = false;
    adj[1][0] = false; adj[1][1] = false; adj[1][2] =  true; adj[1][3] = false; adj[1][4] =  true; adj[1][5] = false; adj[1][6] = false; adj[0][7] = false; adj[1][8] = false;
    adj[2][0] = false; adj[2][1] = false; adj[2][2] = false; adj[2][3] = false; adj[2][4] = false; adj[2][5] =  true; adj[2][6] = false; adj[2][7] = false; adj[2][8] = false;
    adj[3][0] = false; adj[3][1] = false; adj[3][2] = false; adj[3][3] = false; adj[3][4] =  true; adj[3][5] = false; adj[3][6] =  true; adj[3][7] = false; adj[3][8] = false;
    adj[4][0] = false; adj[4][1] = false; adj[4][2] = false; adj[4][3] = false; adj[4][4] = false; adj[4][5] =  true; adj[4][6] = false; adj[4][7] =  true; adj[4][8] = false;
    adj[5][0] = false; adj[5][1] = false; adj[5][2] = false; adj[5][3] = false; adj[5][4] = false; adj[5][5] = false; adj[5][6] = false; adj[5][7] = false; adj[5][8] = false;
    adj[6][0] = false; adj[6][1] = false; adj[6][2] = false; adj[6][3] = false; adj[6][4] =  true; adj[6][5] = false; adj[6][6] = false; adj[6][7] =  true; adj[6][8] = false;
    adj[7][0] = false; adj[7][1] = false; adj[7][2] = false; adj[7][3] = false; adj[7][4] = false; adj[7][5] =  true; adj[7][6] = false; adj[7][7] = false; adj[7][8] =  true;
    adj[8][0] = false; adj[8][1] = false; adj[8][2] = false; adj[8][3] = false; adj[8][4] = false; adj[8][5] = false; adj[8][6] = false; adj[8][7] = false; adj[8][8] = false;

    breadthFirstTraversal(adj, n);

    return 0;
}
