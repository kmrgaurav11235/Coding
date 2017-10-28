/*
Remove duplicate element from sorted Linked List.
The list should only be traversed once.
For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.
*/
#include <iostream>
#include <malloc.h>

using namespace std;

struct Node
{
	int data;
	struct Node * next;
};

void insert_at_end(struct Node **p, int num)
{
	struct Node * temp;
	struct Node * q;
	temp = (struct Node *)malloc(sizeof(struct Node));
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

void display(struct Node * p)
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

struct Node * create_sample_list()
{
	struct Node * p;
	insert_at_end(&p, 11);
	insert_at_end(&p, 11);
	insert_at_end(&p, 11);
	insert_at_end(&p, 21);
	insert_at_end(&p, 43);
	insert_at_end(&p, 43);
	insert_at_end(&p, 60);
	return p;
}

struct Node * removeDuplicates(Node *root)
{
	struct Node * p;
	struct Node * p_prev;
	
	if(root == NULL)
		return root;
		
	p_prev = root;
	p = p_prev -> next;
	
	while(p != NULL)
	{
		if(p_prev -> data == p -> data)
		{
			p_prev -> next = p -> next;
			free(p);
			p = p_prev -> next;
		}
		else
		{
			p_prev = p;
			p = p -> next;
		}
	}
	return root;
}

int main()
{
	struct Node * start = NULL;
	display(start);
	start = create_sample_list();
	display(start);
	start = removeDuplicates(start);
	cout << "\nremoveDuplicates() called.";
	display(start);
	return 0;
}
