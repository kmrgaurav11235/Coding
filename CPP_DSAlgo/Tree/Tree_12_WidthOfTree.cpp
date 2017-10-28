/*
Maximum width of a binary tree

Given a binary tree, write a function to get the maximum width of the given tree. Width of a tree is maximum of widths of all levels.

Let us consider the below example tree.

         1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7

For the above tree,
width of level 1 is 1,
width of level 2 is 2,
width of level 3 is 3
width of level 4 is 2.

So the maximum width of the tree is 3.

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

void traversalForWidth(struct node * p, int height, int horDistance, map <int, int> & m)
{
	if(p == NULL)
		return;
		
	if(m[height])
		m[height]++;
	else
		m[height] = 1;
		
	traversalForWidth(p -> left, height + 1, horDistance - 1, m);
	traversalForWidth(p -> right, height + 1, horDistance + 1, m);
}

int maxWidthOfTree(struct node * p)
{
	map <int, int> m;
	traversalForWidth(p, 0, 0, m);
		
	map <int, int>::iterator i;
	int maxWidth = -1;
	for(i = m.begin(); i != m.end(); i++)
		if(i -> second > maxWidth)
			maxWidth = i -> second;
	return maxWidth;			
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);

	cout << "\nMaximum Width of this Binary Tree:\n" << maxWidthOfTree(root) << ".\n";

	return 0;
}

//Modified Queues can be used for level order traversal too
