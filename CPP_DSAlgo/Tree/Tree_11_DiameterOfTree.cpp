/*
Diameter of a Binary Tree

The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows a tree with diameter nine, the leaves that form the ends of a longest path are in brackets 
(note that there is more than one path of length nine, but no path longer than nine nodes). 
	                    10
	                   /  \
	                  7    19
	                /  \     \
	               3    9    23
	                   /  \    \
	                 11   (16)  44
	                           /  \
	                          4    17
	                        /   \
	                      (5)     14


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
	struct node * q = NULL;
	root = insert_node(p, 10, 1);
	p = insert_node(root, 7, 1);
	p = insert_node(root, 19, 0);
	p = insert_node(root -> left, 3, 1);
	p = insert_node(root -> left, 9, 0);
	p = insert_node(root -> left -> right, 11, 1);
	p = insert_node(root -> left -> right, 16, 0);
	p = insert_node(root -> right, 23, 0);
	p = q = insert_node(p, 44, 0);
	q = insert_node(q, 17, 0);
	p = q = insert_node(p, 4, 1);
	p = insert_node(p, 5, 1);
	p = insert_node(q, 14, 1);
	return root;
	/*
	Tree:
	                    10
	                   /  \
	                  7    19
	                /  \     \
	               3    9    23
	                   /  \    \
	                 11   (16)  44
	                           /  \
	                          4    17
	                        /   \
	                      (5)     14
	*/
}

int diameterOfTree(struct node * p, int & diameter)
{
	if(p == NULL)
	{
		if(diameter < 0)
			diameter = 0;
		return 0;
	}
	
	int leftHeight = diameterOfTree(p -> left, diameter);
	int rightHeight = diameterOfTree(p -> right, diameter);
	
	int currHeight;
	
	if(leftHeight >= rightHeight)
		currHeight = leftHeight + 1;
	else
		currHeight = rightHeight + 1;
		
	if(diameter < (leftHeight + rightHeight + 1))
		diameter = leftHeight + rightHeight + 1;
	
	return currHeight;
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	
	int diameter = -1;	
	diameterOfTree(root, diameter);

	cout << "\nDiameter of this Binary Tree: "<< diameter << ".\n";

	return 0;
}

//Modified Queues can be used for level order traversal too
