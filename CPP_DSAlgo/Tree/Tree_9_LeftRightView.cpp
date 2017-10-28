/*Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
Left view of following tree is 12, 10, 25.
Right view of following tree is 12, 30, 40.

          12
       /     \
     10       30
            /    \
          25      40
*/
#include <iostream>

using namespace std;

struct Node
{
	int data;
	struct Node * left;
	struct Node * right;
};

void preorder_display(struct Node * p)
{
	if (p == NULL)
		return;
	cout << p -> data << " ";
	preorder_display(p -> left);
	preorder_display(p -> right);
}

void inorder_display(struct Node * p)
{
	if (p == NULL)
		return;
	inorder_display(p -> left);
	cout << p -> data << " ";
	inorder_display(p -> right);
}

struct Node * insert_node(struct Node * p, int value, int isLeft)
{
	struct Node * temp = new Node;
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

struct Node * create_tree()
{
	struct Node * root = NULL;
	struct Node * p = NULL;
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

void leftViewOfTree(struct Node * p, int currLevel, int & maxLevel)
{
    if(p == NULL)
        return;
    if(currLevel > maxLevel)
    {
        cout << p -> data << " ";
        maxLevel++;
    }
    leftViewOfTree(p -> left, currLevel + 1, maxLevel);
    leftViewOfTree(p -> right, currLevel + 1, maxLevel);
}

void rightViewOfTree(struct Node * p, int currLevel, int & maxLevel)
{
    if(p == NULL)
        return;
    if(currLevel > maxLevel)
    {
        cout << p -> data << " ";
        maxLevel++;
    }
    leftViewOfTree(p -> right, currLevel + 1, maxLevel);
    leftViewOfTree(p -> left, currLevel + 1, maxLevel);
}

int main()
{
	struct Node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);

	int maxLevel = -1;

	cout << "\nLeft View of this Binary Tree:\n";
	leftViewOfTree(root, 0, maxLevel);
	cout << endl;

    maxLevel = -1;
	cout << "\nRight View of this Binary Tree:\n";
	rightViewOfTree(root, 0, maxLevel);
	cout << endl;

	return 0;
}
