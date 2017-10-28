//Check if a Tree is Binary Search Tree
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

    root = insert_node(p, 1, 1);
	p = insert_node(root, 3, 1);
	p = insert_node(p, 2, 0);

	/*Tree
             20
            /
           10
          /
         5
        /
       2
        \
         3
	*/
//	root = insert_node(p, 20, 1);
//	p = insert_node(root, 10, 1);
//	p = insert_node(p, 5, 1);
//	p = insert_node(p, 2, 1);
//	p = insert_node(p, 3, 0);

//	root = insert_node(p, 10, 1);
//	p = insert_node(root, 7, 1);
//	p = insert_node(root, 19, 0);
//	p = insert_node(root -> left, 3, 1);
//	p = insert_node(root -> left, 9, 0);
//	p = insert_node(root -> right, 23, 0);
//	p = insert_node(p, 16, 1);
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

int isBST(struct node * p, int min, int max)
{
	if (p == NULL)
		return 1;
	if (p -> info < min || p -> info > max)
		return 0;
	if (isBST(p -> left, min, p -> info) && isBST(p -> right, p -> info, max))
		return 1;
	return 0;
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	char * result = isBST(root, INT_MIN, INT_MAX)?(char *)"yes":(char *)"no";
	cout << "\nIs The Given Tree a Binary Search Tree: " << result << ".\n";
	return 0;
}
