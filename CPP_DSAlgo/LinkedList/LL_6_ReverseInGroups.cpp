/*
Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 

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
	if ((*p) == NULL)
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
	struct node * p = NULL;
	insert_at_end(&p, 20);
	insert_at_end(&p, 19);
	insert_at_end(&p, 33);
	insert_at_end(&p, 89);
	insert_at_end(&p, 67);
	//insert_at_end(&p, 40);
	return p;
}

void destroy(struct node * p)
{
	while(p != NULL)
	{
		struct node * temp = p;
		p = p -> next;
		delete temp;
	}
}

struct node * reverseInGroups(struct node * p, int k)
{
	if(k <= 1 || p == NULL || p -> next == NULL)
	{
		return p;
	}
	
	int count = 0;
	struct node * prev = NULL;
	struct node * curr = p;
	struct node * nxt = NULL;
	/*
	prev      curr ->  nxt
	prev  <-  curr     nxt
	x     <-  prev     curr
	*/
	while (curr != NULL && count != k)
	{
		nxt = curr -> next;
		curr -> next = prev;
		prev = curr;
		curr = nxt;
		count++;
	}
	if(curr != NULL)
		p -> next = reverseInGroups(curr, k);
	
	return prev;
}

int main()
{
	struct node * start = NULL;
	int k;
	display(start);
	start = create_sample_list();
	display(start);
	
	cout << "Reverse LL in groups of k.\nEnter k:";
	cin >> k;
	
	start = reverseInGroups(start, k);
	
	cout << "After Reversal:\n";
	display(start);
	
	destroy(start);
	return 0;
}
