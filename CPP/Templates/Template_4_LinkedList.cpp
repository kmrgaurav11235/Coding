#include <iostream>

using namespace std;

template <class T>
class LinkedList
{
	private:
		struct node
		{
			T data;
			struct node * next;
		}*start;
	public:
		LinkedList();
		~LinkedList();
		void addAtBeginning(T info);
		void addAtEnd(T info);
		void addAfterPosition(T info, int pos);
		void deleteByPosition(int pos);
		void display();
		int count();
};

template <class T>
LinkedList<T>::LinkedList()
{
	start = NULL;
}

template <class T>
LinkedList<T>::~LinkedList()
{
	struct node *p;
	while(start != NULL)
	{
		p = start;
		start = start -> next;
		delete p;
	}
}

template <class T>
void LinkedList<T>::addAtBeginning(T info)
{
	struct node * temp = new node;
	temp -> data = info;
	temp -> next = start;
	start = temp;
}

template <class T>
void LinkedList<T>::addAtEnd(T info)
{
	struct node * temp = new node;
	temp -> data = info;
	temp -> next = NULL;
	
	struct node * p = start;
	if(p == NULL)
	{
		start = temp;
		return;
	}
	while(p -> next != NULL)
		p = p -> next;
	p -> next = temp;
}

template <class T>
void LinkedList<T>::addAfterPosition(T info, int pos)
{
	struct node * p = start;
	if(pos == 0)
	{
		addAtBeginning(info);
		return;
	}
	else if(pos < 0)
	{
		cout << "Negative position is not allowed. Node will not be inserted.\n";
		return;
	}
	for(int i = 1; i < pos; i++)
	{
		p = p -> next;
		if(p == NULL)
		{
			cout << "Invalid value!! Less than " << pos << " nodes are present in Linked List. Node will not be inserted.\n";
			return;
		}
	}
	struct node * q = p -> next;
	
	struct node * temp = new node;
	temp -> data = info;
	temp -> next = q;
	p -> next = temp;	
}

template <class T>
void LinkedList<T>::deleteByPosition(int pos)
{
	struct node * p = start;
	struct node * prev = NULL;
	if(pos <= 0)
	{
		cout << "Negative or Zero position is not allowed. No Node will be deleted.\n";
		return;
	}
	for(int i = 1; i < pos; i++)
	{
		if(p == NULL)
		{
			cout << "Invalid value!! Less than " << pos << " nodes are present in Linked List. No Node will be deleted.\n";
			return;
		}
		prev = p;
		p = p -> next;
	}
	struct node * q = p -> next;
	if(prev == NULL)
	{
		start = start -> next;
		delete p;
	}
	else
	{
		prev -> next = q;
		delete p;
	}
}

template <class T>
void LinkedList<T>::display()
{
	struct node * p = start;
	if(p == NULL)
	{
		cout << "Empty List! No item to display.\n";
		return;
	}
	cout << "Linked List Diaplay:\n";
	while(p != NULL)
	{
		cout << p -> data << " ";
		p = p -> next;
	}
	cout << endl;
}

template <class T>
int LinkedList<T>::count()
{
	struct node * p = start;
	int i;
	for(i = 0; p != NULL; i++)
		p = p -> next;
	return i;
}

int main()
{
	LinkedList <int> l1;
	cout << "Number of Elements in Linked List " << l1.count() << ".\n";
	
	l1.addAtEnd(3);
	l1.addAtEnd(1);
	l1.addAtEnd(4);
	l1.addAtEnd(1);
	l1.display();
	
	l1.addAtBeginning(42);
	l1.addAtBeginning(420);
	l1.display();
	
	l1.addAfterPosition(19, 3);
	l1.addAfterPosition(17, 0);
	l1.addAfterPosition(33, 8);
	l1.display();
	l1.addAfterPosition(7, 11);
	l1.display();
	cout << "Number of Elements in Linked List " << l1.count() << ".\n";
	
	l1.deleteByPosition(14);
	l1.deleteByPosition(1);
	l1.deleteByPosition(4);
	l1.deleteByPosition(0);
	l1.display();
	cout << "Number of Elements in Linked List " << l1.count() << ".\n";
	l1.deleteByPosition(7);
	l1.deleteByPosition(6);
	l1.display();
	cout << "Number of Elements in Linked List " << l1.count() << ".\n";
	
	return 0;
}
