/*Write an Efficient Function to Convert a Binary Tree into its Mirror Tree.
Tree:
	                    10
	                   /  \
	                  7    19
	                /  \     \
	               3    9    23
	                        /
	                       16
Mirror:
	                    10
	                   /  \
	                  19    7
	                /     /  \
	               23    9    3
	                \
	                 16

*/
#include <iostream>
#include <map>

using namespace std;

struct node
{
	int data;
	struct node * left;
	struct node * right;
};

void preorder_display(struct node * p)
{
	if (p == NULL)
		return;
	cout << p -> data << " ";
	preorder_display(p -> left);
	preorder_display(p -> right);
}

void inorder_display(struct node * p)
{
	if (p == NULL)
		return;
	inorder_display(p -> left);
	cout << p -> data << " ";
	inorder_display(p -> right);
}

struct node * insert_node(struct node * p, int value, int isLeft)
{
	struct node * temp = new node;
	temp -> data = value;
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

void mirrorOfTree(struct node * p)
{
	if(p == NULL)
		return;
		
	struct node * l = p -> left; 
	struct node * r = p -> right;
	
	p -> left = r;
	p -> right = l;
	
	mirrorOfTree(p -> left);
	mirrorOfTree(p -> right);
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	
	cout << "\nCalling Mirror.\n";
	mirrorOfTree(root);
	
	cout << "Pre-Order Disply of Mirror Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Mirror Tree:\n";
	inorder_display(root);

	return 0;
}

//Modified Queues can be used for level order traversal too
