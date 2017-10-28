//Find the middle element of a LL.
//For Odd Number of elements -> return the middle element
//For Even Number of elements -> return the second middle element
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

struct node * find_mid(struct node * p)
{
	struct node * fast_ptr = p;
	struct node * slow_ptr = p;
	while (fast_ptr != NULL && fast_ptr -> next != NULL)
	{
		fast_ptr = fast_ptr -> next -> next;
		slow_ptr = slow_ptr -> next;
	}
	return slow_ptr;
}

int main()
{
	struct node * start = NULL;
	display(start);
	start = create_sample_list();
	display(start);
	struct node * mid = find_mid(start);
	cout << "Mid of LL: " << mid -> data << endl;
	
	destroy(start);
	return 0;
}
