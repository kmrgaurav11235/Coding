//Check if a LL is a palindrome.
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
	//insert_at_end(&p, 33);
	insert_at_end(&p, 19);
	insert_at_end(&p, 20);
	return p;
}

void reverse_list(struct node ** p)
{
	struct node * prev = NULL;
	struct node * curr = *p;
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
	*p = prev;
}

bool compare_list(struct node * p, struct node * q)
{
	while (p != NULL && q != NULL)
	{
		if(p -> data != q -> data)
			return false;
		p = p -> next;
		q = q -> next;
	}
	if (p == NULL && q == NULL)
		return true;
	return false;
}

bool is_palindrome(struct node * p)
{
	if(p == NULL || p -> next == NULL)
		return true;
	
	struct node * fast_ptr = p;
	struct node * slow_ptr = p;
	struct node * slow_prev = NULL;
	struct node * mid = NULL;
	
	//Find the middle element
	while(fast_ptr != NULL && fast_ptr -> next != NULL)
	{
		fast_ptr = fast_ptr -> next -> next;
		slow_prev = slow_ptr;
		slow_ptr = slow_ptr -> next;
	}
	
	slow_prev -> next = NULL;//1st half seperated
	
	if(fast_ptr != NULL)
	{
		//odd number of elements
		mid = slow_ptr;
		slow_ptr = slow_ptr -> next;
	}
	
	reverse_list(&slow_ptr);
	
	bool result = compare_list(p, slow_ptr);
	
	reverse_list(&slow_ptr);
	if (mid != NULL)
	{
		slow_prev -> next = mid;
		slow_prev = slow_prev -> next;
	}
	slow_prev -> next = slow_ptr;
	
	return result;
}

int main()
{
	struct node * start = NULL;
	display(start);
	start = create_sample_list();
	display(start);
	cout << "\nIs Linked List a Palidrome?" << (is_palindrome(start)?(char *)" Yes.":(char *)" No.") << endl;
	display(start);
	return 0;
}
