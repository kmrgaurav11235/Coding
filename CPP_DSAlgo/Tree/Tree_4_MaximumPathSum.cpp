//Maximum Path Sum in a Binary Tree

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

int max_of_three(int a, int b, int c)
{
	return ((ar >= b) && (a >= c))?(a):(((b >= a) && (b >= c))?b:c);
}

int find_max_path(struct node * p, int * curr_max)
{
	if (p == NULL)
		return 0;
	int left_max = find_max_path(p -> left, curr_max);
	int right_max = find_max_path(p -> right, curr_max);
	
	int return_max = max_of_three(left_max + p -> info, right_max + p -> info, p -> info);
	
	*curr_max = max_of_three(return_max, left_max + (p -> info) + right_max, *curr_max);
	
	return return_max;
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	int curr_max = INT_MIN;
	int temp = find_max_path(root, &curr_max);
	cout << "\nMaximum Path Sum in this Binary Tree: " << curr_max << endl;
	return 0;
}
