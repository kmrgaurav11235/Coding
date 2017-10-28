/*
Remove loop element from a Linked List.
*/
#include <iostream>

using namespace std;

struct node
{
	int data;
	struct node * next;
};

void insert_at_end(struct node **p, int num)
{
	struct node * temp;
	struct node * q;
	temp = new node;
	temp -> data = num;
	temp -> next = NULL;
	if (*p == NULL)
		*p = temp;
	else
	{
		q = *p;
		while (q -> next != NULL)
			q = q->next;
		q -> next = temp;
	}
}

void display(struct node * p)
{
	//Modified to display loops
	cout << "\nLinked List Display:\n";
	int counti = 0;
	if(p == NULL)
		cout << "Empty List.\n";
	else
	{
		while (p != NULL && counti < 20)
		{
			cout << p-> data << " ";
			p = p -> next;
			counti++;
		}
		cout << endl;
	}
}

struct node * create_sample_list()
{
	struct node * p;
	insert_at_end(&p, 11);
	insert_at_end(&p, 2);
	insert_at_end(&p, 17);
	insert_at_end(&p, 21);
	insert_at_end(&p, 3);
	insert_at_end(&p, 43);
	insert_at_end(&p, 60);
	return p;
}

void addLoop(struct node *p)
{
    int n = 3;
    struct node *q = p;
    for (int i = 0; i < n; i++)
        p = p -> next;
    while(q -> next != NULL)
        q = q -> next;
    cout << "\nAdding loop at " << p -> data << endl;
    q -> next = p;
}

void removeLoop(struct node * start, struct node * p)
{
    int counti = 1;
    struct node * q = p -> next;
    while(p != q)
    {
        q = q -> next;
        counti++;
    }

    p = start;
    q = start;

    for(int i = 0; i < counti - 1; i++)
        q = q -> next;

    while(p != q -> next)
    {
        p = p -> next;
        q = q -> next;
    }
    q -> next = NULL;
}

bool findLoop(struct node *start)
{
	struct node * fastPtr = start;
	struct node * slowPtr = start;

	if(start == NULL)
		return true;

    while(fastPtr != NULL && fastPtr -> next != NULL && slowPtr != NULL)
	{
		fastPtr = fastPtr -> next -> next;
		slowPtr = slowPtr -> next;
        if(fastPtr == slowPtr)
        {
            removeLoop(start, fastPtr);
            return true;
        }
	}
    return false;
}

int main()
{
	struct node * start = NULL;
	display(start);
	start = create_sample_list();
	display(start);

	addLoop(start);
	display(start);

	bool isLoopPresent = findLoop(start);
	if(isLoopPresent)
	{
        cout << "\nLoop found and removed.\nNew linked list:\n";
        display(start);
    }
    else
        cout << "\nNo loop found.\n";
	return 0;
}
