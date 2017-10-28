//Find the Min Height of a Tree
#include <iostream>
#include <malloc.h>
#include <climits>

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
	struct node * temp = (struct node *)malloc(sizeof(struct node));
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

int find_min_height_INCORRECT(struct node * p)
{
	if (p == NULL)
		return 0;
		
	int left_height, right_height;
	
	left_height = find_min_height_INCORRECT(p->left);
	right_height = find_min_height_INCORRECT(p->right);
	
	if(left_height < right_height)
		return left_height + 1;
	else
		return right_height + 1;
}

int find_min_height(struct node * p)
{
	if (p == NULL)
		return 0;
	int left_height = INT_MAX, right_height = INT_MAX;
	if (p -> left == NULL && p -> right == NULL)//Handling Condition for p being leaf-node
		return 1;
	else if (p -> left != NULL)
		left_height = find_min_height(p -> left);
	else if (p -> right != NULL)
		right_height = find_min_height(p -> right);
	return ((left_height < right_height)?(left_height + 1):(right_height+ 1));
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	cout << "\nHeight of Tree by INCORRECT method = " << find_min_height_INCORRECT(root) << endl;
	cout << "\nHeight of Tree by CORRECT method = " << find_min_height(root) << endl;
	return 0;
}
