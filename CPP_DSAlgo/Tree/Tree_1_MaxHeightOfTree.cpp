//Find the Max Height of a Tree
#include <iostream>

using namespace std;

struct node
{
	int info;
	struct node * left;
	struct node * right;
};

void preorder_display(struct node * p)
{
	if (p == NULL)
		return;
	cout << p -> info << " ";
	preorder_display(p -> left);
	preorder_display(p -> right);
}

void inorder_display(struct node * p)
{
	if (p == NULL)
		return;
	inorder_display(p -> left);
	cout << p -> info << " ";
	inorder_display(p -> right);
}

struct node * insert_node(struct node * p, int value, int isLeft)
{
	struct node * temp = new node;
	temp -> info = value;
	temp -> left = NULL;
	temp -> right = NULL;
	
	if(p == NULL)
		return temp;	
	else if(isLeft)
		p -> left = temp;
	else
		p -> right = temp;
	return temp;
}

struct node * create_tree()
{
	struct node * root = NULL;
	struct node * p = NULL;
	root = insert_node(p, 10, 1);
	p = insert_node(root, 7, 1);
	p = insert_node(root, 19, 0);
	p = insert_node(root -> left, 3, 1);
	p = insert_node(root -> left, 9, 0);
	p = insert_node(root -> right, 23, 0);
	p = insert_node(p, 16, 1);
	return root;
	/*
	Tree:
	                    10
	                   /  \
	                  7    19
	                /  \     \
	               3    9    23
	                        /
	                       16
	*/
}

void destroyTree(struct node * p)
{
	if (p == NULL)
		return;
	destroyTree(p -> left);
	destroyTree(p -> right);
	delete p;
}

int find_max_height(struct node * p)
{
	if (p == NULL)
		return 0;
		
	int left_height, right_height;
	
	left_height = find_max_height(p->left);
	right_height = find_max_height(p->right);
	
	if(left_height >= right_height)
		return left_height + 1;
	else
		return right_height + 1;
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	cout << "\nHeight of Tree = " << find_max_height(root) << endl;
	destroyTree(root);
	return 0;
}
