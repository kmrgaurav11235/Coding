//Reverse a LL.
#include <iostream>
#include <malloc.h>

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
	temp = (struct node *)malloc(sizeof(struct node));
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
	cout << "\nLinked List Display:\n";
	if(p == NULL)
		cout << "Empty List.\n";
	else
	{
		while (p != NULL)
		{
			cout << p-> data << " ";
			p = p -> next;
		}
		cout << endl;
	}
}

struct node * create_sample_list()
{
	struct node * p;
	insert_at_end(&p, 20);
	insert_at_end(&p, 19);
	insert_at_end(&p, 33);
	insert_at_end(&p, 89);
	insert_at_end(&p, 67);
	insert_at_end(&p, 40);
	return p;
}

struct node * reverse_list(struct node * p)
{
	struct node * prev = NULL;
	struct node * curr = p;
	struct node * nxt = NULL;
	/*
	prev      curr ->  nxt
	prev  <-  curr     nxt
	x     <-  prev     curr
	*/
	while (curr != NULL)
	{
		nxt = curr -> next;
		curr -> next = prev;
		prev = curr;
		curr = nxt;
	}
	return prev;
}

int main()
{
	struct node * start = NULL;
	display(start);
	start = create_sample_list();
	display(start);
	start = reverse_list(start);
	cout << "\nReverse called.";
	display(start);
	return 0;
}
